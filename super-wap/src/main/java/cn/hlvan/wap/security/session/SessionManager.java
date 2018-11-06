package cn.hlvan.wap.security.session;

import cn.hlvan.wap.constant.SystemCode;
import cn.hlvan.wap.security.permission.RequirePermission;
import cn.hlvan.wap.service.AuthorizedOperator;
import cn.hlvan.wap.service.PermissionService;
import cn.hlvan.wap.util.CookieUtils;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Component
public class SessionManager extends HandlerInterceptorAdapter implements HandlerMethodArgumentResolver {


    @Value("${sso.auth.url}")
    private String ssoUrl;

    @Autowired
    private Gson gson;

    private static final String login="/auth/#/login";
    private StringRedisTemplate redis;
    @Value("${sso-token}")
    private String ssoToken;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    public void setRedis(StringRedisTemplate redis) {
        redis.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        this.redis = redis;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        boolean needAuthenticated = AnnotationUtils.findAnnotation(method.getBeanType().getPackage(), Authenticated.class) != null;
        if (!needAuthenticated){
            needAuthenticated = AnnotationUtils.findAnnotation(method.getBeanType(), Authenticated.class) != null;
            if (!needAuthenticated) {
                needAuthenticated = method.hasMethodAnnotation(Authenticated.class);

                if (!needAuthenticated) {
                    needAuthenticated = Stream.of(method.getMethodParameters()).anyMatch(
                        p -> p.hasParameterAnnotation(Authenticated.class)
                    );
                }
            }
        }

        if (!needAuthenticated) {
            return true;
        }
        HttpSession session = request.getSession(true);
        AuthorizedOperator authorizedUser ;
        //检查用户是否过期
        String cookieValue = CookieUtils.getCookieValue(request, ssoToken);
        //请求中没有token
        if (StringUtils.isBlank(cookieValue)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ssoUrl+login);
            return false;
        }
        String s = redis.opsForValue().get(cookieValue);
        if (StringUtils.isNotBlank(s)){
            redis.expire(cookieValue, 24, TimeUnit.HOURS);
            authorizedUser = gson.fromJson(s, AuthorizedOperator.class);
            session.setAttribute(Authenticated.class.getName(),authorizedUser);
        }else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ssoUrl+login);
            return false;
        }
        request.setAttribute(Authenticated.class.getName(), authorizedUser);

        //编写admin与管理员的权限控制
        boolean needPermission = AnnotationUtils.findAnnotation(method.getBeanType(), RequirePermission.class) != null;
        if (!needPermission) {
            needPermission = method.hasMethodAnnotation(RequirePermission.class);
        }
        if (!needPermission) {
            return true;
        }

        RequirePermission requirePermission = AnnotationUtils.findAnnotation(method.getBeanType(), RequirePermission.class);
        if (requirePermission == null) {
            requirePermission = AnnotationUtils.findAnnotation(method.getMethod(), RequirePermission.class);
        }
        if ( permissionService.hasPermission(SystemCode.SSO_AUTH.name(),authorizedUser.getId(),
            requirePermission.value())){
            return true;
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN,ssoUrl+login);
        return false;

    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Authenticated.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory
    ) {
        return webRequest.getAttribute(Authenticated.class.getName(), RequestAttributes.SCOPE_REQUEST);
    }

    public void bind(HttpSession session, Object userId) {
        session.setAttribute(Authenticated.class.getName(), userId);
        session.setAttribute(FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, getIndexValue(userId));
        session.setMaxInactiveInterval(1800);
    }

    @SuppressWarnings("unused")
    public void unbind(HttpSession session) {
        session.invalidate();
    }

    private String getIndexValue(Object userId) {
        return (userId instanceof Indexed) ? ((Indexed) userId).getIndexValue() : String.valueOf(userId);
    }

    public interface Indexed {

        String getIndexValue();

    }

}

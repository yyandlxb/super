package cn.hlvan.pc.security.session;

import cn.hlvan.pc.merchant.controller.AuthorizedUser;
import cn.hlvan.pc.security.permission.RequirePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
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
import java.util.stream.Stream;

@Component
public class SessionManager extends HandlerInterceptorAdapter implements HandlerMethodArgumentResolver {


//    @Autowired
//    MerchantPermissionService merchantPermissionService;

    private FindByIndexNameSessionRepository<? extends Session> sessionRepository;

    @Autowired
    public void setSessionRepository(FindByIndexNameSessionRepository<? extends Session> sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod method = (HandlerMethod) handler;
        boolean needAuthenticated = AnnotationUtils.findAnnotation(method.getBeanType(), Authenticated.class) != null;
        if (!needAuthenticated) {
            needAuthenticated = method.hasMethodAnnotation(Authenticated.class);

            if (!needAuthenticated) {
                needAuthenticated = Stream.of(method.getMethodParameters()).anyMatch(
                    p -> p.hasParameterAnnotation(Authenticated.class)
                );
            }
        }

        if (!needAuthenticated) {
            return true;
        }


        HttpSession session = request.getSession(false);


        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        Object value = session.getAttribute(Authenticated.class.getName());
        if (value == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        request.setAttribute(Authenticated.class.getName(), value);

        boolean needPermission = AnnotationUtils.findAnnotation(method.getBeanType(), RequirePermission.class) != null;
        if (!needPermission) {
            needPermission = method.hasMethodAnnotation(RequirePermission.class);
        }
        if (!needPermission) {
            return true;
        }

        Integer userId = ((AuthorizedUser) value).getId();

        RequirePermission requirePermission = AnnotationUtils.findAnnotation(method.getBeanType(), RequirePermission.class);
        if (requirePermission == null) {
            requirePermission = AnnotationUtils.findAnnotation(method.getMethod(), RequirePermission.class);
        }
        /*if (merchantPermissionService.hasPermission(userId, requirePermission.value())) {
            return true;
        }*/
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
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
    }

    @SuppressWarnings("unused")
    public void unbind(HttpSession session) {
        session.invalidate();
    }

    private String getIndexValue(Object userId) {
        return (userId instanceof Indexed) ? ((Indexed) userId).getIndexValue() : String.valueOf(userId);
    }

    public void invalidateAll(Object userId) {
        sessionRepository.findByIndexNameAndIndexValue(
            FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, getIndexValue(userId)
        ).forEach((sid, session) -> sessionRepository.deleteById(sid));
    }

    public interface Indexed {

        String getIndexValue();

    }
}

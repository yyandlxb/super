package cn.hlvan.wap.api.controller;

import cn.hlvan.wap.constant.UserType;
import cn.hlvan.wap.service.AuthorizedOperator;
import cn.hlvan.wap.util.Reply;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static cn.hlvan.database.Tables.*;
import static cn.hlvan.database.tables.UserRole.USER_ROLE;

@Controller("ssoAipUserController")
@RequestMapping("/sso_api/user")
public class UserController {

    private DSLContext dsl;
    private StringRedisTemplate redis;

    private Gson gson;
    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }
    @Autowired
    public void setRedis(StringRedisTemplate redis) {
        redis.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        this.redis = redis;
    }
    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    /**
     * 用户有效性查询
     * @param token token值
     * @return 返回信息
     */
    @GetMapping("/info")
    @ResponseBody
    public Reply checkUser(@RequestParam String token){
        String user = redis.opsForValue().get(token);
        if (StringUtils.isNotBlank(user)){
            redis.expire(token,24,TimeUnit.HOURS);
            return Reply.success().data(gson.fromJson(user, AuthorizedOperator.class));
        }else {
            return Reply.fail();
        }
    }

    /**
     * 权限有效性查询
     * @param request 请求request
     * @param token token值
     * @param code 权限码
     * @param systemCode 系统码
     * @return 返回j成功或失败son
     */
    @GetMapping("/permission")
    @ResponseBody
    public Reply checkPermission(HttpServletRequest request, @RequestParam String token, @RequestParam String code
        , @RequestParam String systemCode){
        AuthorizedOperator user = (AuthorizedOperator) request.getSession().getAttribute(token);
        if (null == user){
            String u = redis.opsForValue().get(token);
            if (StringUtils.isNotBlank(u)) {
                user = gson.fromJson(u, AuthorizedOperator.class);
                request.getSession().setAttribute(token, user);
            }else {
                request.getSession().invalidate();
                return Reply.fail().message("token过期");
            }
        }
        if (user.getType() == UserType.MANAGER) {
            return Reply.success();
        }
        Boolean permission = false;
        if (user.getPermission() != null)
            permission = user.getPermission().get(systemCode + code + token);
        if (permission != null && permission){
            return Reply.success();
        }else {
            int execute = dsl.selectCount().from(USER_ROLE).innerJoin(ROLE).on(USER_ROLE.ROLE_ID.eq(ROLE.ID))
                             .innerJoin(ROLE_PERMISSION).on(ROLE_PERMISSION.ROLE_ID.eq(ROLE.ID))
                             .innerJoin(PERMISSION).on(PERMISSION.ID.eq(ROLE_PERMISSION.PERMISSION_ID))
                             .innerJoin(SYSTEM).on(PERMISSION.SYSTEM_ID.eq(SYSTEM.ID)).and(SYSTEM.CODE.eq(systemCode))
                             .and(PERMISSION.CODE.eq(code)).and(USER_ROLE.USER_ID.eq(user.getId())).fetchOne().value1();
            if (execute>0){
                Map<String, Boolean> perm = user.getPermission();
                if (null == perm){
                    perm = new HashMap<>();
                }
                perm.put(systemCode + code + token,true);
                //加入缓存
//                user.setPermission(perm);
                return Reply.success();
            }else {
                return Reply.fail().message("没有权限");
            }
        }
    }

}

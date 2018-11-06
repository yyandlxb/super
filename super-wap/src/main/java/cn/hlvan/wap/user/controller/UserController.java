package cn.hlvan.wap.user.controller;

import cn.hlvan.wap.constant.InfoCode;
import cn.hlvan.wap.security.session.Authenticated;
import cn.hlvan.wap.security.session.SessionManager;
import cn.hlvan.wap.service.AuthorizedOperator;
import cn.hlvan.wap.service.user.UserService;
import cn.hlvan.wap.util.CookieUtils;
import cn.hlvan.wap.util.MD5Util;
import cn.hlvan.wap.util.Reply;
import cn.hlvan.wap.view.User;
import cn.hlvan.database.tables.records.UserRecord;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static cn.hlvan.database.tables.User.USER;

@Controller("userController")
@RequestMapping("/user")
public class UserController {

    private JavaMailSenderImpl javaMailSender;
    @Value("${sso.auth.url}")
    private String resetPasswordLink;
    private static final String passwordLink = "/auth/#/password";
    private Gson gson;
    @Value("${spring.mail.username}")
    private String fromMail;
    private DSLContext dsl;
    private StringRedisTemplate redis;
    @Value("${sso-token}")
    private String ssoToken;
    @Value("${cookie-domain}")
    private String cookieDomain;
    @Value("${cookie-path}")
    private String cookiePath;

    private SessionManager sessionManager;
    private UserService userService;
    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }
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
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/sign_in")
    @ResponseBody
    public Reply signIn(@RequestParam String account, @RequestParam String password, HttpServletRequest request,
                        HttpServletResponse response) {
        String pw = MD5Util.MD5Encode(password, null);

        AuthorizedOperator u = dsl.select(USER.fields())
                    .from(USER)
                    .where(USER.ACCOUNT.eq(account))
                    .and(USER.PASSWORD.eq(pw))
                    .and(USER.ENABLED.isTrue())
                    .fetchOneInto(AuthorizedOperator.class);
        if (null == u){
            return Reply.fail().data(InfoCode.AUTH_ERROR);
        }
        sessionManager.bind(request.getSession(), new AuthorizedOperator(u.getName(),u.getId(), u.getDepartmentId()
            ,u.getAccount(),u.getType()));
        //登录用户数据存在redis中
        String token = UUID.randomUUID().toString();
        String user = gson.toJson(u);
        Boolean value = redis.opsForValue().setIfAbsent(token, user);
        if (value) {
            redis.expire(token, 24, TimeUnit.HOURS);
        }
        //写COOKIE
        Cookie cookie = new Cookie(ssoToken,token);
        cookie.setDomain(cookieDomain);
        cookie.setMaxAge(cookie.getMaxAge());
        cookie.setPath(cookiePath);
        response.addCookie(cookie);

        return Reply.success();
    }

    @PostMapping("/sign_out")
    @ResponseBody
    public Reply signOut(HttpServletRequest request){

        //获取Cookie值
        String cookieValue = CookieUtils.getCookieValue(request, ssoToken);
        //删除redis中的值
        Boolean delete = redis.delete(cookieValue);
        if (delete){
            sessionManager.unbind(request.getSession());
            return Reply.success();
        }else {
            return Reply.fail().message("退出失败");
        }
    }

    @PostMapping("/password/update")
    @ResponseBody
    public Reply updatePassword(@Authenticated AuthorizedOperator user, String oldPassword, String password){

        String pw = MD5Util.MD5Encode(oldPassword, null);
        User u = dsl.selectFrom(USER)
                    .where(USER.ID.eq(user.getId()))
                    .and(USER.PASSWORD.eq(pw))
                    .and(USER.ENABLED.isTrue())
                    .fetchOneInto(User.class);
        if (null != u){
            String pd = MD5Util.MD5Encode(password, null);
            userService.modifyPassword(pd,user.getId());
            return Reply.success();

        }else {
            return Reply.fail().message("原密码错误");
        }

    }
    @PostMapping("/password/forget")
    @ResponseBody
    public Reply checkAccount(@RequestParam String account){
        UserRecord userRecord = dsl.select(USER.fields()).from(USER).where(USER.ACCOUNT.eq(account))
                                   .and(USER.ENABLED.isTrue())
                                   .fetchOneInto(UserRecord.class);

        if (userRecord != null){
            String pt = UUID.randomUUID().toString();
            redis.opsForValue().set(pt,userRecord.getId().toString());
            redis.expire(pt, 30, TimeUnit.MINUTES);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromMail);
            message.setTo(account);
            message.setSubject("华凌密码忘记，密码重置");
            message.setText("请勿回复本邮件.点击下面的链接,重设密码,本邮件超过30分钟,链接将会失效，需要重新申请找回密码"
                            +resetPasswordLink+passwordLink+"/randomId="+pt+"&account="+account);
            javaMailSender.send(message);
            return Reply.success();
        }else {
            return Reply.fail().message("账号不存在");
        }
    }


    //邮件链接忘记密码，重置
    @PostMapping("/reset")
    @ResponseBody
    public Reply resetPassword(@RequestParam String randomId,@RequestParam String password){

        String s = redis.opsForValue().get(randomId);
        if (StringUtils.isNotBlank(s)){
            String pw = MD5Util.MD5Encode(password, null);
            Integer integer = userService.resetPassword(Integer.parseInt(s), pw);
            if (integer>0){
                return Reply.success();
            }else {
                return Reply.fail().message("修改失败");
            }
        }else {
            return Reply.fail().message("修改失败");
        }

    }

    @PostMapping("/info")
    @ResponseBody
    public Reply updatePassword(@Authenticated AuthorizedOperator user){

        UserRecord userRecord = dsl.select(USER.fields()).from(USER).where(USER.ID.eq(user.getId()))
                                   .and(USER.ENABLED.isTrue())
                                   .fetchOneInto(UserRecord.class);
        return Reply.success().data(userRecord);

    }
}

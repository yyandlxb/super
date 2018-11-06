package cn.hlvan.pc.user.controller;

import cn.hlvan.database.tables.records.UserRecord;
import cn.hlvan.pc.merchant.controller.AuthorizedUser;
import cn.hlvan.pc.security.session.SessionManager;
import cn.hlvan.pc.util.MD5Util;
import cn.hlvan.pc.util.Reply;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static cn.hlvan.database.tables.User.USER;

@Controller("pcUserController")
@RequestMapping("/user")
public class UserController {

    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    private SessionManager sessionManager;

    @Autowired
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @PostMapping("/sign_in")
    @ResponseBody
    public Reply login(String userName, String password, HttpServletRequest request){

        String s = MD5Util.MD5Encode(password, null);
        UserRecord userRecord = dsl.selectFrom(USER).where(USER.ACCOUNT.eq(userName).and(USER.PASSWORD.eq(s))).fetchOne();
        if (null == userRecord)
            return Reply.fail().data("明户名或密码错误");
        sessionManager.bind(request.getSession(true),
            new AuthorizedUser(userRecord.getId(),userRecord.getType(),userRecord.getName()));
        return Reply.success();
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

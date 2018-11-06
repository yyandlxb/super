package cn.hlvan.wap.api.controller;

import cn.hlvan.wap.service.AuthorizedOperator;
import cn.hlvan.wap.service.api.UploadPermissionService;
import cn.hlvan.wap.util.Reply;
import cn.hlvan.wap.view.Permission;
import cn.hlvan.wap.view.UploadPermissionView;
import cn.hlvan.database.tables.UserRole;
import cn.hlvan.database.tables.records.PermissionRecord;
import cn.hlvan.database.tables.records.SystemRecord;
import cn.hlvan.database.tables.records.UserRecord;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static cn.hlvan.database.tables.Permission.PERMISSION;
import static cn.hlvan.database.tables.Role.ROLE;
import static cn.hlvan.database.tables.RolePermission.ROLE_PERMISSION;
import static cn.hlvan.database.tables.System.SYSTEM;
import static cn.hlvan.database.tables.User.USER;

@Controller("ssoPermissionUserController")
@RequestMapping("/sso_api/permission")
public class PermissionController {

    private DSLContext dsl;
    private UploadPermissionService uploadPermissionService;
    private StringRedisTemplate redis;


    private Gson gson;
    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }
    @Autowired
    public void setUploadPermissionService(UploadPermissionService uploadPermissionService) {
        this.uploadPermissionService = uploadPermissionService;
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
     * 提供子系统查询权限列表
     *
     * @param request 请求
     * @param token token值
     * @param systemCode 系统码
     */
    @GetMapping("/list")
    @ResponseBody
    public Reply listPermission(HttpServletRequest request, @RequestParam String token, String systemCode) {
        AuthorizedOperator user = (AuthorizedOperator) request.getSession().getAttribute(token);
        if (user == null) {
            String s = redis.opsForValue().get(token);
            if (StringUtils.isNotBlank(s)) {
                user = gson.fromJson(s, AuthorizedOperator.class);
                request.getSession().setAttribute(token, user);
            } else {
                return Reply.fail();
            }
        }
        List<PermissionRecord> permissionRecords;
        if (user != null) {
            Permission permission = new Permission();
            UserRecord userRecord = dsl.select(USER.ID,USER.NAME, USER.TYPE, USER.ACCOUNT).from(USER)
                                       .where(USER.ID.eq(user.getId()))
                                       .and(USER.ENABLED.isTrue())
                                       .fetchOneInto(UserRecord.class);
            if (user.getType() == 1) {

                permissionRecords = dsl.select(PERMISSION.fields()).from(PERMISSION)
                                       .innerJoin(SYSTEM).on(PERMISSION.SYSTEM_ID.eq(SYSTEM.ID))
                                       .and(SYSTEM.CODE.eq(systemCode)).fetchInto(PermissionRecord.class);
            } else {
                permissionRecords = dsl.select(PERMISSION.fields()).from(UserRole.USER_ROLE)
                                       .innerJoin(ROLE)
                                       .on(ROLE.ID.eq(UserRole.USER_ROLE.ROLE_ID))
                                       .and(ROLE.ENABLED.isTrue())
                                       .and(UserRole.USER_ROLE.USER_ID.eq(user.getId()))
                                       .innerJoin(ROLE_PERMISSION)
                                       .on(ROLE.ID.eq(ROLE_PERMISSION.ROLE_ID))
                                       .innerJoin(PERMISSION)
                                       .on(ROLE_PERMISSION.PERMISSION_ID.eq(PERMISSION.ID))
                                       .innerJoin(SYSTEM).on(PERMISSION.SYSTEM_ID.eq(SYSTEM.ID))
                                       .and(SYSTEM.CODE.eq(systemCode))
                                       .fetchInto(PermissionRecord.class);
            }
//            permission.setPermissionRecord(permissionRecords);
//            permission.setUserRecord(userRecord);
            return Reply.success().data(permission);
        } else {
            return Reply.fail();
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public Reply addPermission(String permission, String systemCode) {

        //查询是哪个系统上报权限
        SystemRecord systemRecords = dsl.selectFrom(SYSTEM)
                                        .where(SYSTEM.CODE.eq(systemCode))
                                        .fetchOneInto(SystemRecord.class);

        if (systemRecords != null) {
            List<UploadPermissionView> uploadPermissionViews;
            try {
                uploadPermissionViews = gson.fromJson(permission,
                    new TypeToken<List<UploadPermissionView>>() {}.getType());
            } catch (Exception e) {
                return Reply.fail().message("json信息错误");
            }
            uploadPermissionService.addPermission(uploadPermissionViews, systemRecords);
            return Reply.success();

        } else {
            return Reply.fail().message("系统码不存在");
        }

    }

}

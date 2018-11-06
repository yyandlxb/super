package cn.hlvan.wap.service;

import cn.hlvan.wap.constant.SystemCode;
import cn.hlvan.wap.constant.UserType;
import cn.hlvan.wap.security.permission.PermissionEnum;
import cn.hlvan.wap.service.api.UploadPermissionService;
import cn.hlvan.wap.view.UploadPermissionView;
import cn.hlvan.database.Tables;
import cn.hlvan.database.tables.Permission;
import cn.hlvan.database.tables.RolePermission;
import cn.hlvan.database.tables.UserRole;
import cn.hlvan.database.tables.records.SystemRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cn.hlvan.database.tables.System.SYSTEM;

@Service
public class PermissionService  implements InitializingBean {

    @Value("${permission.refresh}")
    private Integer refresh;
    private DSLContext dsl;
    private UploadPermissionService uploadPermissionService;
    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }
    @Autowired
    public void setUploadPermissionService(UploadPermissionService uploadPermissionService) {
        this.uploadPermissionService = uploadPermissionService;
    }

    public boolean hasPermission(String systemCode, Integer userIde, PermissionEnum code) {

        Integer type = dsl.select(Tables.USER.TYPE).from(Tables.USER).where(Tables.USER.ID.eq(userIde)).fetchSingleInto(Integer.class);
        if (type == UserType.ADMIN || type == UserType.MANAGER) {
            return true;
        }

        Integer integer = dsl.selectCount().from(UserRole.USER_ROLE)
                             .innerJoin(Tables.ROLE)
                             .on(Tables.ROLE.ID.eq(UserRole.USER_ROLE.ROLE_ID))
                             .and(Tables.ROLE.ENABLED.isTrue())
                             .innerJoin(RolePermission.ROLE_PERMISSION)
                             .on(UserRole.USER_ROLE.ROLE_ID.eq(RolePermission.ROLE_PERMISSION.ROLE_ID))
                             .and(UserRole.USER_ROLE.USER_ID.eq(userIde))
                             .innerJoin(Permission.PERMISSION)
                             .on(RolePermission.ROLE_PERMISSION.PERMISSION_ID.eq(Permission.PERMISSION.ID))
                             .innerJoin(SYSTEM).on(Permission.PERMISSION.SYSTEM_ID.eq(SYSTEM.ID))
                             .and(SYSTEM.CODE.eq(systemCode))
                             .and(Permission.PERMISSION.CODE.eq(code.name()))
                             .fetchOne().value1();
        return integer > 0;
    }

    @Override
    public void afterPropertiesSet(){
        if(refresh.equals(0)){
            return;
        }
        String code, name;
        List<UploadPermissionView> uploadPermissionViews = new ArrayList<>();
        for (PermissionEnum permissionEnum : PermissionEnum.values()) {
            UploadPermissionView uploadPermissionView = new UploadPermissionView();
            code = permissionEnum.name();
            name = permissionEnum.getName();
            uploadPermissionView.setCode(code);
            uploadPermissionView.setName(name);
            uploadPermissionViews.add(uploadPermissionView);
        }
        SystemRecord systemRecord = dsl.selectFrom(SYSTEM)
                                       .where(SYSTEM.CODE.eq(SystemCode.SSO_AUTH.name()))
                                       .fetchOneInto(SystemRecord.class);
        uploadPermissionService.addPermission(uploadPermissionViews,systemRecord);
    }
}

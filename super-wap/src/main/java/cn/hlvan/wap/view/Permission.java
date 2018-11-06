package cn.hlvan.wap.view;

import cn.hlvan.database.tables.records.PermissionRecord;
import cn.hlvan.database.tables.records.SystemRecord;
import cn.hlvan.database.tables.records.UserRecord;
import lombok.Data;

import java.util.List;

@Data
public class Permission  {

    private List<PermissionRecord> permissionRecord;
    private List<SystemRecord> systemRecord;
    private UserRecord userRecord;
}

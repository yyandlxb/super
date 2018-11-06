package cn.hlvan.wap.view;

import cn.hlvan.database.tables.records.PermissionRecord;
import cn.hlvan.database.tables.records.RoleRecord;
import lombok.Data;

import java.util.List;

@Data
public class RolePermissionView {
    private RoleRecord roleRecord;
    private List<PermissionRecord> permissionRecords;
}

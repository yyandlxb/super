package cn.hlvan.wap.view;

import cn.hlvan.database.tables.records.RoleRecord;
import lombok.Data;

import java.util.List;

@Data
public class UserRoleView {
    private String name;
    private Integer id;
    private String account;
    private List<RoleRecord> recordList;
    private String departmentName;
}

package cn.hlvan.wap.view;

import cn.hlvan.database.tables.records.RoleRecord;
import lombok.Data;

import java.util.List;

@Data
public class DepartRoeView {
    private String departmentName;
    private String name;
    private Integer id;
    private List<RoleRecord> roleRecords;

}

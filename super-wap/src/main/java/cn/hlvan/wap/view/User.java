package cn.hlvan.wap.view;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer id;
    private Integer departmentId;
    private String departmentName;
    private String account;
    private Integer type;
}

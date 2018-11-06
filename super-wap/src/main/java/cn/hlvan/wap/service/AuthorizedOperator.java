package cn.hlvan.wap.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class AuthorizedOperator implements Serializable {
    private static final long serialVersionUID = -4780472610099438045L;

    private String name;
    private Integer id;
    private Integer departmentId;
    private String account;
    private Integer type;
    private Map<String,Boolean> permission;

    public AuthorizedOperator(String name, Integer id, Integer departmentId, String account, Integer type) {
        this.name = name;
        this.id = id;
        this.departmentId = departmentId;
        this.account = account;
        this.type=type;
    }

}

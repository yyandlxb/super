package cn.hlvan.pc.merchant.controller;

import cn.hlvan.pc.security.session.SessionManager;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AuthorizedUser implements Serializable, SessionManager.Indexed {

    private static final long serialVersionUID = 3933889168576006480L;

    private Integer id;

    private Byte type;

    private String name;


    @Override
    public String getIndexValue() {
        return id + "/" + type;
    }

}

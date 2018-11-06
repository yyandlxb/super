package cn.hlvan.wap.service.user;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.hlvan.database.tables.User.USER;

@Service
@Transactional
public class UserService {


    private DSLContext dsl;
    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void modifyPassword(String password, Integer id) {
        dsl.update(USER).set(USER.PASSWORD,password).where(USER.ID.eq(id)).execute();
    }

    public Integer resetPassword(Integer accountId, String password) {
        return dsl.update(USER).set(USER.PASSWORD,password)
                  .where(USER.ID.eq(accountId))
                  .and(USER.ENABLED.isTrue()).execute();
    }
}

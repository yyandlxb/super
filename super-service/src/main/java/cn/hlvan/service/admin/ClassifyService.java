package cn.hlvan.service.admin;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.hlvan.database.tables.CommodityClassify.COMMODITY_CLASSIFY;

@Service
public class ClassifyService {
    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Transactional
    public boolean create(String name) {
        return dsl.insertInto(COMMODITY_CLASSIFY).set(COMMODITY_CLASSIFY.NAME, name).onDuplicateKeyIgnore().execute() > 0;
    }
}

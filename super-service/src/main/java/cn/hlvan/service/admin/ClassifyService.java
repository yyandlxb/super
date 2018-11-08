package cn.hlvan.service.admin;

import lombok.Data;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.hlvan.database.tables.CommodityClassify.COMMODITY_CLASSIFY;

@Service
@Transactional
public class ClassifyService {
    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public boolean create(String name, Integer pId) {
        return dsl.insertInto(COMMODITY_CLASSIFY).set(COMMODITY_CLASSIFY.NAME, name)
                  .set(COMMODITY_CLASSIFY.P_ID,pId)
                  .onDuplicateKeyIgnore().execute() > 0;
    }

    public boolean update(String name, Integer id) {
        return dsl.update(COMMODITY_CLASSIFY).set(COMMODITY_CLASSIFY.NAME, name).where(COMMODITY_CLASSIFY.ID.eq(id)).execute() > 0;
    }

    public boolean delete(Integer id) {
        return dsl.update(COMMODITY_CLASSIFY)
                  .set(COMMODITY_CLASSIFY.ENABLED, false)
                  .where(COMMODITY_CLASSIFY.ID.eq(id).or(COMMODITY_CLASSIFY.P_ID.eq(id))).execute() > 0;

    }

}

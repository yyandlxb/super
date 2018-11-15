package cn.hlvan.service.admin;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.hlvan.database.tables.GoodsClassify.GOODS_CLASSIFY;

@Service
@Transactional
public class ClassifyService {
    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public boolean create(String name, Integer pId) {
        return dsl.insertInto(GOODS_CLASSIFY).set(GOODS_CLASSIFY.NAME, name)
                  .set(GOODS_CLASSIFY.P_ID,pId)
                  .onDuplicateKeyIgnore().execute() > 0;
    }

    public boolean update(String name, Integer id) {
        return dsl.update(GOODS_CLASSIFY).set(GOODS_CLASSIFY.NAME, name).where(GOODS_CLASSIFY.ID.eq(id)).execute() > 0;
    }

    public boolean delete(Integer id) {
        return dsl.update(GOODS_CLASSIFY)
                  .set(GOODS_CLASSIFY.ENABLED, false)
                  .where(GOODS_CLASSIFY.ID.eq(id).or(GOODS_CLASSIFY.P_ID.eq(id))).execute() > 0;

    }

}

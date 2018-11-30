package cn.hlvan.service.admin;

import cn.hlvan.database.tables.records.BrandRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.hlvan.database.Tables.BRAND;

@Service
public class BrandService {

    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Transactional
    public boolean createBrand(String brandName) {

        return dsl.insertInto(BRAND).set(BRAND.NAME, brandName).onDuplicateKeyIgnore().execute() > 0;
    }

    @Transactional
    public Boolean delete(Integer id,Boolean status) {

        return  dsl.update(BRAND).set(BRAND.ENABLED, status).where(BRAND.ID.eq(id)).execute() > 0;
    }

    public boolean update(BrandRecord brandRecord) {
        return dsl.executeUpdate(brandRecord) >0;
    }
}

package cn.hlvan.service;

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
    public boolean createBrand(String brandName){

        BrandRecord brandRecord = new BrandRecord();
        brandRecord.setName(brandName);
        return  dsl.executeUpdate(brandRecord) > 0;
    }

    public void delete(Integer[] ids) {

        dsl.deleteFrom(BRAND).where(BRAND.ID.in(ids)).execute();
    }

    public void update(BrandRecord brandRecord) {
        dsl.executeUpdate(brandRecord);
    }
}

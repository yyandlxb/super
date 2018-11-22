package cn.hlvan.service.merchant;

import cn.hlvan.database.tables.records.GoodsRecord;
import lombok.Data;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class GoodsService {

    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Transactional
    public void create(GoodsForm goodsForm) {
        GoodsRecord goodsRecord = new GoodsRecord();
        goodsRecord.from(goodsForm);
        dsl.executeInsert(goodsRecord);
    }

    @Data
    public class GoodsForm{

        private String classifyName;
        private String name;
        private String picture;
        private String  producer;
        private Integer brandId;
        private Integer classifyId;
        private BigDecimal price;
        private BigDecimal costPrice;
        private Double weight;
        private String describe;

        private Integer merchantId;
    }
}

/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database.tables;


import cn.hlvan.database.Indexes;
import cn.hlvan.database.Keys;
import cn.hlvan.database.Super;
import cn.hlvan.database.tables.records.GoodsRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Goods extends TableImpl<GoodsRecord> {

    private static final long serialVersionUID = 1572619919;

    /**
     * The reference instance of <code>super.goods</code>
     */
    public static final Goods GOODS = new Goods();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GoodsRecord> getRecordType() {
        return GoodsRecord.class;
    }

    /**
     * The column <code>super.goods.id</code>. 商品id
     */
    public final TableField<GoodsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "商品id");

    /**
     * The column <code>super.goods.name</code>. 商品名称
     */
    public final TableField<GoodsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "商品名称");

    /**
     * The column <code>super.goods.classify_id</code>. 分类id
     */
    public final TableField<GoodsRecord, Integer> CLASSIFY_ID = createField("classify_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "分类id");

    /**
     * The column <code>super.goods.describe</code>. 商品简介
     */
    public final TableField<GoodsRecord, String> DESCRIBE = createField("describe", org.jooq.impl.SQLDataType.VARCHAR(255), this, "商品简介");

    /**
     * The column <code>super.goods.enabled</code>. 0-上架，1-下架
     */
    public final TableField<GoodsRecord, Boolean> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'1'", org.jooq.impl.SQLDataType.BIT)), this, "0-上架，1-下架");

    /**
     * The column <code>super.goods.picture</code>. 商品图片
     */
    public final TableField<GoodsRecord, String> PICTURE = createField("picture", org.jooq.impl.SQLDataType.VARCHAR(255), this, "商品图片");

    /**
     * The column <code>super.goods.created_at</code>.
     */
    public final TableField<GoodsRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.goods.updated_at</code>.
     */
    public final TableField<GoodsRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.goods.merchant_id</code>. 供应商id
     */
    public final TableField<GoodsRecord, Integer> MERCHANT_ID = createField("merchant_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "供应商id");

    /**
     * The column <code>super.goods.sale_total</code>. 销售量
     */
    public final TableField<GoodsRecord, Integer> SALE_TOTAL = createField("sale_total", org.jooq.impl.SQLDataType.INTEGER, this, "销售量");

    /**
     * The column <code>super.goods.details</code>. 商品详情
     */
    public final TableField<GoodsRecord, String> DETAILS = createField("details", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "商品详情");

    /**
     * The column <code>super.goods.status</code>. 0-待审核，1-审核成功，2-审核失败
     */
    public final TableField<GoodsRecord, Byte> STATUS = createField("status", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "0-待审核，1-审核成功，2-审核失败");

    /**
     * The column <code>super.goods.price</code>. 商品价格
     */
    public final TableField<GoodsRecord, BigDecimal> PRICE = createField("price", org.jooq.impl.SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "商品价格");

    /**
     * The column <code>super.goods.producer</code>. 生产厂商
     */
    public final TableField<GoodsRecord, String> PRODUCER = createField("producer", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "生产厂商");

    /**
     * The column <code>super.goods.weight</code>. 重量
     */
    public final TableField<GoodsRecord, Double> WEIGHT = createField("weight", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "重量");

    /**
     * The column <code>super.goods.cost_price</code>. 进货价
     */
    public final TableField<GoodsRecord, Long> COST_PRICE = createField("cost_price", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("10", org.jooq.impl.SQLDataType.BIGINT)), this, "进货价");

    /**
     * The column <code>super.goods.brand_id</code>.
     */
    public final TableField<GoodsRecord, Integer> BRAND_ID = createField("brand_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>super.goods</code> table reference
     */
    public Goods() {
        this(DSL.name("goods"), null);
    }

    /**
     * Create an aliased <code>super.goods</code> table reference
     */
    public Goods(String alias) {
        this(DSL.name(alias), GOODS);
    }

    /**
     * Create an aliased <code>super.goods</code> table reference
     */
    public Goods(Name alias) {
        this(alias, GOODS);
    }

    private Goods(Name alias, Table<GoodsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Goods(Name alias, Table<GoodsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Super.SUPER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.GOODS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<GoodsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_GOODS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GoodsRecord> getPrimaryKey() {
        return Keys.KEY_GOODS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GoodsRecord>> getKeys() {
        return Arrays.<UniqueKey<GoodsRecord>>asList(Keys.KEY_GOODS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Goods as(String alias) {
        return new Goods(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Goods as(Name alias) {
        return new Goods(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Goods rename(String name) {
        return new Goods(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Goods rename(Name name) {
        return new Goods(name, null);
    }
}

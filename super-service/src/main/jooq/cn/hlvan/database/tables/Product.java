/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database.tables;


import cn.hlvan.database.Indexes;
import cn.hlvan.database.Keys;
import cn.hlvan.database.Super;
import cn.hlvan.database.tables.records.ProductRecord;

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
public class Product extends TableImpl<ProductRecord> {

    private static final long serialVersionUID = 936339463;

    /**
     * The reference instance of <code>super.product</code>
     */
    public static final Product PRODUCT = new Product();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductRecord> getRecordType() {
        return ProductRecord.class;
    }

    /**
     * The column <code>super.product.id</code>. 商品库存
     */
    public final TableField<ProductRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "商品库存");

    /**
     * The column <code>super.product.product_code</code>. 产品id
     */
    public final TableField<ProductRecord, String> PRODUCT_CODE = createField("product_code", org.jooq.impl.SQLDataType.VARCHAR(50), this, "产品id");

    /**
     * The column <code>super.product.created_at</code>.
     */
    public final TableField<ProductRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.product.updated_at</code>.
     */
    public final TableField<ProductRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.product.pass_time</code>. 过期时间
     */
    public final TableField<ProductRecord, Timestamp> PASS_TIME = createField("pass_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "过期时间");

    /**
     * The column <code>super.product.commodity_id</code>. 商品id
     */
    public final TableField<ProductRecord, Integer> COMMODITY_ID = createField("commodity_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "商品id");

    /**
     * The column <code>super.product.product_date</code>. 生产日期
     */
    public final TableField<ProductRecord, Timestamp> PRODUCT_DATE = createField("product_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "生产日期");

    /**
     * The column <code>super.product.status</code>. 0-待出售，1-已售出，2-已过期
     */
    public final TableField<ProductRecord, Byte> STATUS = createField("status", org.jooq.impl.SQLDataType.TINYINT, this, "0-待出售，1-已售出，2-已过期");

    /**
     * Create a <code>super.product</code> table reference
     */
    public Product() {
        this(DSL.name("product"), null);
    }

    /**
     * Create an aliased <code>super.product</code> table reference
     */
    public Product(String alias) {
        this(DSL.name(alias), PRODUCT);
    }

    /**
     * Create an aliased <code>super.product</code> table reference
     */
    public Product(Name alias) {
        this(alias, PRODUCT);
    }

    private Product(Name alias, Table<ProductRecord> aliased) {
        this(alias, aliased, null);
    }

    private Product(Name alias, Table<ProductRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PRODUCT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ProductRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PRODUCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProductRecord> getPrimaryKey() {
        return Keys.KEY_PRODUCT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProductRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductRecord>>asList(Keys.KEY_PRODUCT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product as(String alias) {
        return new Product(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product as(Name alias) {
        return new Product(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(String name) {
        return new Product(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(Name name) {
        return new Product(name, null);
    }
}

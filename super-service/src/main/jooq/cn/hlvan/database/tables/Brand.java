/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database.tables;


import cn.hlvan.database.Indexes;
import cn.hlvan.database.Keys;
import cn.hlvan.database.Super;
import cn.hlvan.database.tables.records.BrandRecord;

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
public class Brand extends TableImpl<BrandRecord> {

    private static final long serialVersionUID = -62139684;

    /**
     * The reference instance of <code>super.brand</code>
     */
    public static final Brand BRAND = new Brand();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BrandRecord> getRecordType() {
        return BrandRecord.class;
    }

    /**
     * The column <code>super.brand.id</code>. 品牌id
     */
    public final TableField<BrandRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "品牌id");

    /**
     * The column <code>super.brand.name</code>. 品牌名称
     */
    public final TableField<BrandRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "品牌名称");

    /**
     * The column <code>super.brand.created_at</code>.
     */
    public final TableField<BrandRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.brand.updated_at</code>.
     */
    public final TableField<BrandRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.brand.enabled</code>.
     */
    public final TableField<BrandRecord, Boolean> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'1'", org.jooq.impl.SQLDataType.BIT)), this, "");

    /**
     * Create a <code>super.brand</code> table reference
     */
    public Brand() {
        this(DSL.name("brand"), null);
    }

    /**
     * Create an aliased <code>super.brand</code> table reference
     */
    public Brand(String alias) {
        this(DSL.name(alias), BRAND);
    }

    /**
     * Create an aliased <code>super.brand</code> table reference
     */
    public Brand(Name alias) {
        this(alias, BRAND);
    }

    private Brand(Name alias, Table<BrandRecord> aliased) {
        this(alias, aliased, null);
    }

    private Brand(Name alias, Table<BrandRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.BRAND_PRIMARY, Indexes.BRAND_UK_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<BrandRecord, Integer> getIdentity() {
        return Keys.IDENTITY_BRAND;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BrandRecord> getPrimaryKey() {
        return Keys.KEY_BRAND_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BrandRecord>> getKeys() {
        return Arrays.<UniqueKey<BrandRecord>>asList(Keys.KEY_BRAND_PRIMARY, Keys.KEY_BRAND_UK_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Brand as(String alias) {
        return new Brand(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Brand as(Name alias) {
        return new Brand(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Brand rename(String name) {
        return new Brand(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Brand rename(Name name) {
        return new Brand(name, null);
    }
}

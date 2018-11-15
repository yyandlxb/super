/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database.tables;


import cn.hlvan.database.Indexes;
import cn.hlvan.database.Keys;
import cn.hlvan.database.Super;
import cn.hlvan.database.tables.records.GoodsClassifyRecord;

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
public class GoodsClassify extends TableImpl<GoodsClassifyRecord> {

    private static final long serialVersionUID = 1858930774;

    /**
     * The reference instance of <code>super.goods_classify</code>
     */
    public static final GoodsClassify GOODS_CLASSIFY = new GoodsClassify();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GoodsClassifyRecord> getRecordType() {
        return GoodsClassifyRecord.class;
    }

    /**
     * The column <code>super.goods_classify.id</code>. 商品分类
     */
    public final TableField<GoodsClassifyRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "商品分类");

    /**
     * The column <code>super.goods_classify.name</code>. 分类名称
     */
    public final TableField<GoodsClassifyRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "分类名称");

    /**
     * The column <code>super.goods_classify.p_id</code>. 父分类id
     */
    public final TableField<GoodsClassifyRecord, Integer> P_ID = createField("p_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "父分类id");

    /**
     * The column <code>super.goods_classify.created_at</code>.
     */
    public final TableField<GoodsClassifyRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.goods_classify.updated_at</code>.
     */
    public final TableField<GoodsClassifyRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.goods_classify.enabled</code>. 是否可用
     */
    public final TableField<GoodsClassifyRecord, Boolean> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'1'", org.jooq.impl.SQLDataType.BIT)), this, "是否可用");

    /**
     * Create a <code>super.goods_classify</code> table reference
     */
    public GoodsClassify() {
        this(DSL.name("goods_classify"), null);
    }

    /**
     * Create an aliased <code>super.goods_classify</code> table reference
     */
    public GoodsClassify(String alias) {
        this(DSL.name(alias), GOODS_CLASSIFY);
    }

    /**
     * Create an aliased <code>super.goods_classify</code> table reference
     */
    public GoodsClassify(Name alias) {
        this(alias, GOODS_CLASSIFY);
    }

    private GoodsClassify(Name alias, Table<GoodsClassifyRecord> aliased) {
        this(alias, aliased, null);
    }

    private GoodsClassify(Name alias, Table<GoodsClassifyRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.GOODS_CLASSIFY_PRIMARY, Indexes.GOODS_CLASSIFY_UK_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<GoodsClassifyRecord, Integer> getIdentity() {
        return Keys.IDENTITY_GOODS_CLASSIFY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GoodsClassifyRecord> getPrimaryKey() {
        return Keys.KEY_GOODS_CLASSIFY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GoodsClassifyRecord>> getKeys() {
        return Arrays.<UniqueKey<GoodsClassifyRecord>>asList(Keys.KEY_GOODS_CLASSIFY_PRIMARY, Keys.KEY_GOODS_CLASSIFY_UK_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoodsClassify as(String alias) {
        return new GoodsClassify(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoodsClassify as(Name alias) {
        return new GoodsClassify(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GoodsClassify rename(String name) {
        return new GoodsClassify(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GoodsClassify rename(Name name) {
        return new GoodsClassify(name, null);
    }
}
/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database.tables.records;


import cn.hlvan.database.tables.BrandClassify;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class BrandClassifyRecord extends UpdatableRecordImpl<BrandClassifyRecord> implements Record4<Integer, Integer, Integer, Timestamp> {

    private static final long serialVersionUID = 859165751;

    /**
     * Setter for <code>super.brand_classify.id</code>. 商标与类别
     */
    public BrandClassifyRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>super.brand_classify.id</code>. 商标与类别
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>super.brand_classify.brand_id</code>. 品牌id
     */
    public BrandClassifyRecord setBrandId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>super.brand_classify.brand_id</code>. 品牌id
     */
    public Integer getBrandId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>super.brand_classify.classify</code>. 类别id
     */
    public BrandClassifyRecord setClassify(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>super.brand_classify.classify</code>. 类别id
     */
    public Integer getClassify() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>super.brand_classify.created_at</code>.
     */
    public BrandClassifyRecord setCreatedAt(Timestamp value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>super.brand_classify.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Timestamp> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return BrandClassify.BRAND_CLASSIFY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return BrandClassify.BRAND_CLASSIFY.BRAND_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return BrandClassify.BRAND_CLASSIFY.CLASSIFY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return BrandClassify.BRAND_CLASSIFY.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getBrandId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getClassify();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getBrandId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getClassify();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BrandClassifyRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BrandClassifyRecord value2(Integer value) {
        setBrandId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BrandClassifyRecord value3(Integer value) {
        setClassify(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BrandClassifyRecord value4(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BrandClassifyRecord values(Integer value1, Integer value2, Integer value3, Timestamp value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BrandClassifyRecord
     */
    public BrandClassifyRecord() {
        super(BrandClassify.BRAND_CLASSIFY);
    }

    /**
     * Create a detached, initialised BrandClassifyRecord
     */
    public BrandClassifyRecord(Integer id, Integer brandId, Integer classify, Timestamp createdAt) {
        super(BrandClassify.BRAND_CLASSIFY);

        set(0, id);
        set(1, brandId);
        set(2, classify);
        set(3, createdAt);
    }
}

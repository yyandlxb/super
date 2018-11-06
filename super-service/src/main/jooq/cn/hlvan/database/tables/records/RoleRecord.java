/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database.tables.records;


import cn.hlvan.database.tables.Role;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class RoleRecord extends UpdatableRecordImpl<RoleRecord> implements Record6<Integer, String, Integer, Boolean, Timestamp, Timestamp> {

    private static final long serialVersionUID = 1153560362;

    /**
     * Setter for <code>super.role.id</code>. 角色id
     */
    public RoleRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>super.role.id</code>. 角色id
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>super.role.name</code>. 角色名称
     */
    public RoleRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>super.role.name</code>. 角色名称
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>super.role.department_id</code>. 部门id
     */
    public RoleRecord setDepartmentId(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>super.role.department_id</code>. 部门id
     */
    public Integer getDepartmentId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>super.role.enabled</code>.
     */
    public RoleRecord setEnabled(Boolean value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>super.role.enabled</code>.
     */
    public Boolean getEnabled() {
        return (Boolean) get(3);
    }

    /**
     * Setter for <code>super.role.created_at</code>.
     */
    public RoleRecord setCreatedAt(Timestamp value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>super.role.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>super.role.updated_at</code>.
     */
    public RoleRecord setUpdatedAt(Timestamp value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>super.role.updated_at</code>.
     */
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, Integer, Boolean, Timestamp, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, Integer, Boolean, Timestamp, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Role.ROLE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Role.ROLE.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Role.ROLE.DEPARTMENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field4() {
        return Role.ROLE.ENABLED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Role.ROLE.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Role.ROLE.UPDATED_AT;
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
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getDepartmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component4() {
        return getEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getUpdatedAt();
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getDepartmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value4() {
        return getEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRecord value3(Integer value) {
        setDepartmentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRecord value4(Boolean value) {
        setEnabled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRecord value5(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRecord value6(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleRecord values(Integer value1, String value2, Integer value3, Boolean value4, Timestamp value5, Timestamp value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoleRecord
     */
    public RoleRecord() {
        super(Role.ROLE);
    }

    /**
     * Create a detached, initialised RoleRecord
     */
    public RoleRecord(Integer id, String name, Integer departmentId, Boolean enabled, Timestamp createdAt, Timestamp updatedAt) {
        super(Role.ROLE);

        set(0, id);
        set(1, name);
        set(2, departmentId);
        set(3, enabled);
        set(4, createdAt);
        set(5, updatedAt);
    }
}

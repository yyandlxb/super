/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database.tables;


import cn.hlvan.database.Indexes;
import cn.hlvan.database.Keys;
import cn.hlvan.database.Super;
import cn.hlvan.database.tables.records.SystemRecord;

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
public class System extends TableImpl<SystemRecord> {

    private static final long serialVersionUID = -941676021;

    /**
     * The reference instance of <code>super.system</code>
     */
    public static final System SYSTEM = new System();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SystemRecord> getRecordType() {
        return SystemRecord.class;
    }

    /**
     * The column <code>super.system.id</code>. 系统id
     */
    public final TableField<SystemRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "系统id");

    /**
     * The column <code>super.system.code</code>. 系统码
     */
    public final TableField<SystemRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "系统码");

    /**
     * The column <code>super.system.name</code>. 系统名称
     */
    public final TableField<SystemRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "系统名称");

    /**
     * The column <code>super.system.enabled</code>.
     */
    public final TableField<SystemRecord, Boolean> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'1'", org.jooq.impl.SQLDataType.BIT)), this, "");

    /**
     * The column <code>super.system.created_at</code>.
     */
    public final TableField<SystemRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>super.system.updated_at</code>.
     */
    public final TableField<SystemRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>super.system</code> table reference
     */
    public System() {
        this(DSL.name("system"), null);
    }

    /**
     * Create an aliased <code>super.system</code> table reference
     */
    public System(String alias) {
        this(DSL.name(alias), SYSTEM);
    }

    /**
     * Create an aliased <code>super.system</code> table reference
     */
    public System(Name alias) {
        this(alias, SYSTEM);
    }

    private System(Name alias, Table<SystemRecord> aliased) {
        this(alias, aliased, null);
    }

    private System(Name alias, Table<SystemRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.SYSTEM_PRIMARY, Indexes.SYSTEM_UK_SYSTEM_CODE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SystemRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SYSTEM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SystemRecord> getPrimaryKey() {
        return Keys.KEY_SYSTEM_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SystemRecord>> getKeys() {
        return Arrays.<UniqueKey<SystemRecord>>asList(Keys.KEY_SYSTEM_PRIMARY, Keys.KEY_SYSTEM_UK_SYSTEM_CODE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public System as(String alias) {
        return new System(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public System as(Name alias) {
        return new System(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public System rename(String name) {
        return new System(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public System rename(Name name) {
        return new System(name, null);
    }
}

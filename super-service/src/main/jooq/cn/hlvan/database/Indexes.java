/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database;


import cn.hlvan.database.tables.Brand;
import cn.hlvan.database.tables.BrandClassify;
import cn.hlvan.database.tables.Commodity;
import cn.hlvan.database.tables.CommodityClassify;
import cn.hlvan.database.tables.CommodityStock;
import cn.hlvan.database.tables.Permission;
import cn.hlvan.database.tables.Role;
import cn.hlvan.database.tables.RolePermission;
import cn.hlvan.database.tables.System;
import cn.hlvan.database.tables.User;
import cn.hlvan.database.tables.UserRole;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>super</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index BRAND_PRIMARY = Indexes0.BRAND_PRIMARY;
    public static final Index BRAND_UK_NAME = Indexes0.BRAND_UK_NAME;
    public static final Index BRAND_CLASSIFY_PRIMARY = Indexes0.BRAND_CLASSIFY_PRIMARY;
    public static final Index COMMODITY_PRIMARY = Indexes0.COMMODITY_PRIMARY;
    public static final Index COMMODITY_CLASSIFY_PRIMARY = Indexes0.COMMODITY_CLASSIFY_PRIMARY;
    public static final Index COMMODITY_CLASSIFY_UK_NAME = Indexes0.COMMODITY_CLASSIFY_UK_NAME;
    public static final Index COMMODITY_STOCK_PRIMARY = Indexes0.COMMODITY_STOCK_PRIMARY;
    public static final Index PERMISSION_PRIMARY = Indexes0.PERMISSION_PRIMARY;
    public static final Index PERMISSION_UK_CODE_SYSTEM = Indexes0.PERMISSION_UK_CODE_SYSTEM;
    public static final Index ROLE_PRIMARY = Indexes0.ROLE_PRIMARY;
    public static final Index ROLE_PERMISSION_PRIMARY = Indexes0.ROLE_PERMISSION_PRIMARY;
    public static final Index SYSTEM_PRIMARY = Indexes0.SYSTEM_PRIMARY;
    public static final Index SYSTEM_UK_SYSTEM_CODE = Indexes0.SYSTEM_UK_SYSTEM_CODE;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;
    public static final Index USER_UK_ACCOUNT = Indexes0.USER_UK_ACCOUNT;
    public static final Index USER_ROLE_PRIMARY = Indexes0.USER_ROLE_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index BRAND_PRIMARY = Internal.createIndex("PRIMARY", Brand.BRAND, new OrderField[] { Brand.BRAND.ID }, true);
        public static Index BRAND_UK_NAME = Internal.createIndex("uk_name", Brand.BRAND, new OrderField[] { Brand.BRAND.NAME }, true);
        public static Index BRAND_CLASSIFY_PRIMARY = Internal.createIndex("PRIMARY", BrandClassify.BRAND_CLASSIFY, new OrderField[] { BrandClassify.BRAND_CLASSIFY.ID }, true);
        public static Index COMMODITY_PRIMARY = Internal.createIndex("PRIMARY", Commodity.COMMODITY, new OrderField[] { Commodity.COMMODITY.ID }, true);
        public static Index COMMODITY_CLASSIFY_PRIMARY = Internal.createIndex("PRIMARY", CommodityClassify.COMMODITY_CLASSIFY, new OrderField[] { CommodityClassify.COMMODITY_CLASSIFY.ID }, true);
        public static Index COMMODITY_CLASSIFY_UK_NAME = Internal.createIndex("uk_name", CommodityClassify.COMMODITY_CLASSIFY, new OrderField[] { CommodityClassify.COMMODITY_CLASSIFY.NAME }, true);
        public static Index COMMODITY_STOCK_PRIMARY = Internal.createIndex("PRIMARY", CommodityStock.COMMODITY_STOCK, new OrderField[] { CommodityStock.COMMODITY_STOCK.ID }, true);
        public static Index PERMISSION_PRIMARY = Internal.createIndex("PRIMARY", Permission.PERMISSION, new OrderField[] { Permission.PERMISSION.ID }, true);
        public static Index PERMISSION_UK_CODE_SYSTEM = Internal.createIndex("uk_code_system", Permission.PERMISSION, new OrderField[] { Permission.PERMISSION.CODE, Permission.PERMISSION.SYSTEM_ID }, true);
        public static Index ROLE_PRIMARY = Internal.createIndex("PRIMARY", Role.ROLE, new OrderField[] { Role.ROLE.ID }, true);
        public static Index ROLE_PERMISSION_PRIMARY = Internal.createIndex("PRIMARY", RolePermission.ROLE_PERMISSION, new OrderField[] { RolePermission.ROLE_PERMISSION.ID }, true);
        public static Index SYSTEM_PRIMARY = Internal.createIndex("PRIMARY", System.SYSTEM, new OrderField[] { System.SYSTEM.ID }, true);
        public static Index SYSTEM_UK_SYSTEM_CODE = Internal.createIndex("uk_system_code", System.SYSTEM, new OrderField[] { System.SYSTEM.CODE }, true);
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.ID }, true);
        public static Index USER_UK_ACCOUNT = Internal.createIndex("uk_account", User.USER, new OrderField[] { User.USER.ACCOUNT }, true);
        public static Index USER_ROLE_PRIMARY = Internal.createIndex("PRIMARY", UserRole.USER_ROLE, new OrderField[] { UserRole.USER_ROLE.ID }, true);
    }
}

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
import cn.hlvan.database.tables.records.BrandClassifyRecord;
import cn.hlvan.database.tables.records.BrandRecord;
import cn.hlvan.database.tables.records.CommodityClassifyRecord;
import cn.hlvan.database.tables.records.CommodityRecord;
import cn.hlvan.database.tables.records.CommodityStockRecord;
import cn.hlvan.database.tables.records.PermissionRecord;
import cn.hlvan.database.tables.records.RolePermissionRecord;
import cn.hlvan.database.tables.records.RoleRecord;
import cn.hlvan.database.tables.records.SystemRecord;
import cn.hlvan.database.tables.records.UserRecord;
import cn.hlvan.database.tables.records.UserRoleRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>super</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<BrandRecord, Integer> IDENTITY_BRAND = Identities0.IDENTITY_BRAND;
    public static final Identity<BrandClassifyRecord, Integer> IDENTITY_BRAND_CLASSIFY = Identities0.IDENTITY_BRAND_CLASSIFY;
    public static final Identity<CommodityRecord, Integer> IDENTITY_COMMODITY = Identities0.IDENTITY_COMMODITY;
    public static final Identity<CommodityClassifyRecord, Integer> IDENTITY_COMMODITY_CLASSIFY = Identities0.IDENTITY_COMMODITY_CLASSIFY;
    public static final Identity<CommodityStockRecord, Integer> IDENTITY_COMMODITY_STOCK = Identities0.IDENTITY_COMMODITY_STOCK;
    public static final Identity<PermissionRecord, Integer> IDENTITY_PERMISSION = Identities0.IDENTITY_PERMISSION;
    public static final Identity<RoleRecord, Integer> IDENTITY_ROLE = Identities0.IDENTITY_ROLE;
    public static final Identity<RolePermissionRecord, Integer> IDENTITY_ROLE_PERMISSION = Identities0.IDENTITY_ROLE_PERMISSION;
    public static final Identity<SystemRecord, Integer> IDENTITY_SYSTEM = Identities0.IDENTITY_SYSTEM;
    public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;
    public static final Identity<UserRoleRecord, Integer> IDENTITY_USER_ROLE = Identities0.IDENTITY_USER_ROLE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BrandRecord> KEY_BRAND_PRIMARY = UniqueKeys0.KEY_BRAND_PRIMARY;
    public static final UniqueKey<BrandRecord> KEY_BRAND_UK_NAME = UniqueKeys0.KEY_BRAND_UK_NAME;
    public static final UniqueKey<BrandClassifyRecord> KEY_BRAND_CLASSIFY_PRIMARY = UniqueKeys0.KEY_BRAND_CLASSIFY_PRIMARY;
    public static final UniqueKey<CommodityRecord> KEY_COMMODITY_PRIMARY = UniqueKeys0.KEY_COMMODITY_PRIMARY;
    public static final UniqueKey<CommodityClassifyRecord> KEY_COMMODITY_CLASSIFY_PRIMARY = UniqueKeys0.KEY_COMMODITY_CLASSIFY_PRIMARY;
    public static final UniqueKey<CommodityClassifyRecord> KEY_COMMODITY_CLASSIFY_UK_NAME = UniqueKeys0.KEY_COMMODITY_CLASSIFY_UK_NAME;
    public static final UniqueKey<CommodityStockRecord> KEY_COMMODITY_STOCK_PRIMARY = UniqueKeys0.KEY_COMMODITY_STOCK_PRIMARY;
    public static final UniqueKey<PermissionRecord> KEY_PERMISSION_PRIMARY = UniqueKeys0.KEY_PERMISSION_PRIMARY;
    public static final UniqueKey<PermissionRecord> KEY_PERMISSION_UK_CODE_SYSTEM = UniqueKeys0.KEY_PERMISSION_UK_CODE_SYSTEM;
    public static final UniqueKey<RoleRecord> KEY_ROLE_PRIMARY = UniqueKeys0.KEY_ROLE_PRIMARY;
    public static final UniqueKey<RolePermissionRecord> KEY_ROLE_PERMISSION_PRIMARY = UniqueKeys0.KEY_ROLE_PERMISSION_PRIMARY;
    public static final UniqueKey<SystemRecord> KEY_SYSTEM_PRIMARY = UniqueKeys0.KEY_SYSTEM_PRIMARY;
    public static final UniqueKey<SystemRecord> KEY_SYSTEM_UK_SYSTEM_CODE = UniqueKeys0.KEY_SYSTEM_UK_SYSTEM_CODE;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_UK_ACCOUNT = UniqueKeys0.KEY_USER_UK_ACCOUNT;
    public static final UniqueKey<UserRoleRecord> KEY_USER_ROLE_PRIMARY = UniqueKeys0.KEY_USER_ROLE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<BrandRecord, Integer> IDENTITY_BRAND = Internal.createIdentity(Brand.BRAND, Brand.BRAND.ID);
        public static Identity<BrandClassifyRecord, Integer> IDENTITY_BRAND_CLASSIFY = Internal.createIdentity(BrandClassify.BRAND_CLASSIFY, BrandClassify.BRAND_CLASSIFY.ID);
        public static Identity<CommodityRecord, Integer> IDENTITY_COMMODITY = Internal.createIdentity(Commodity.COMMODITY, Commodity.COMMODITY.ID);
        public static Identity<CommodityClassifyRecord, Integer> IDENTITY_COMMODITY_CLASSIFY = Internal.createIdentity(CommodityClassify.COMMODITY_CLASSIFY, CommodityClassify.COMMODITY_CLASSIFY.ID);
        public static Identity<CommodityStockRecord, Integer> IDENTITY_COMMODITY_STOCK = Internal.createIdentity(CommodityStock.COMMODITY_STOCK, CommodityStock.COMMODITY_STOCK.ID);
        public static Identity<PermissionRecord, Integer> IDENTITY_PERMISSION = Internal.createIdentity(Permission.PERMISSION, Permission.PERMISSION.ID);
        public static Identity<RoleRecord, Integer> IDENTITY_ROLE = Internal.createIdentity(Role.ROLE, Role.ROLE.ID);
        public static Identity<RolePermissionRecord, Integer> IDENTITY_ROLE_PERMISSION = Internal.createIdentity(RolePermission.ROLE_PERMISSION, RolePermission.ROLE_PERMISSION.ID);
        public static Identity<SystemRecord, Integer> IDENTITY_SYSTEM = Internal.createIdentity(System.SYSTEM, System.SYSTEM.ID);
        public static Identity<UserRecord, Integer> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.ID);
        public static Identity<UserRoleRecord, Integer> IDENTITY_USER_ROLE = Internal.createIdentity(UserRole.USER_ROLE, UserRole.USER_ROLE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<BrandRecord> KEY_BRAND_PRIMARY = Internal.createUniqueKey(Brand.BRAND, "KEY_brand_PRIMARY", Brand.BRAND.ID);
        public static final UniqueKey<BrandRecord> KEY_BRAND_UK_NAME = Internal.createUniqueKey(Brand.BRAND, "KEY_brand_uk_name", Brand.BRAND.NAME);
        public static final UniqueKey<BrandClassifyRecord> KEY_BRAND_CLASSIFY_PRIMARY = Internal.createUniqueKey(BrandClassify.BRAND_CLASSIFY, "KEY_brand_classify_PRIMARY", BrandClassify.BRAND_CLASSIFY.ID);
        public static final UniqueKey<CommodityRecord> KEY_COMMODITY_PRIMARY = Internal.createUniqueKey(Commodity.COMMODITY, "KEY_commodity_PRIMARY", Commodity.COMMODITY.ID);
        public static final UniqueKey<CommodityClassifyRecord> KEY_COMMODITY_CLASSIFY_PRIMARY = Internal.createUniqueKey(CommodityClassify.COMMODITY_CLASSIFY, "KEY_commodity_classify_PRIMARY", CommodityClassify.COMMODITY_CLASSIFY.ID);
        public static final UniqueKey<CommodityClassifyRecord> KEY_COMMODITY_CLASSIFY_UK_NAME = Internal.createUniqueKey(CommodityClassify.COMMODITY_CLASSIFY, "KEY_commodity_classify_uk_name", CommodityClassify.COMMODITY_CLASSIFY.NAME);
        public static final UniqueKey<CommodityStockRecord> KEY_COMMODITY_STOCK_PRIMARY = Internal.createUniqueKey(CommodityStock.COMMODITY_STOCK, "KEY_commodity_stock_PRIMARY", CommodityStock.COMMODITY_STOCK.ID);
        public static final UniqueKey<PermissionRecord> KEY_PERMISSION_PRIMARY = Internal.createUniqueKey(Permission.PERMISSION, "KEY_permission_PRIMARY", Permission.PERMISSION.ID);
        public static final UniqueKey<PermissionRecord> KEY_PERMISSION_UK_CODE_SYSTEM = Internal.createUniqueKey(Permission.PERMISSION, "KEY_permission_uk_code_system", Permission.PERMISSION.CODE, Permission.PERMISSION.SYSTEM_ID);
        public static final UniqueKey<RoleRecord> KEY_ROLE_PRIMARY = Internal.createUniqueKey(Role.ROLE, "KEY_role_PRIMARY", Role.ROLE.ID);
        public static final UniqueKey<RolePermissionRecord> KEY_ROLE_PERMISSION_PRIMARY = Internal.createUniqueKey(RolePermission.ROLE_PERMISSION, "KEY_role_permission_PRIMARY", RolePermission.ROLE_PERMISSION.ID);
        public static final UniqueKey<SystemRecord> KEY_SYSTEM_PRIMARY = Internal.createUniqueKey(System.SYSTEM, "KEY_system_PRIMARY", System.SYSTEM.ID);
        public static final UniqueKey<SystemRecord> KEY_SYSTEM_UK_SYSTEM_CODE = Internal.createUniqueKey(System.SYSTEM, "KEY_system_uk_system_code", System.SYSTEM.CODE);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.ID);
        public static final UniqueKey<UserRecord> KEY_USER_UK_ACCOUNT = Internal.createUniqueKey(User.USER, "KEY_user_uk_account", User.USER.ACCOUNT);
        public static final UniqueKey<UserRoleRecord> KEY_USER_ROLE_PRIMARY = Internal.createUniqueKey(UserRole.USER_ROLE, "KEY_user_role_PRIMARY", UserRole.USER_ROLE.ID);
    }
}

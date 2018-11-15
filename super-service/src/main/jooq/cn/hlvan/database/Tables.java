/*
 * This file is generated by jOOQ.
*/
package cn.hlvan.database;


import cn.hlvan.database.tables.Brand;
import cn.hlvan.database.tables.BrandClassify;
import cn.hlvan.database.tables.Goods;
import cn.hlvan.database.tables.GoodsClassify;
import cn.hlvan.database.tables.Permission;
import cn.hlvan.database.tables.Product;
import cn.hlvan.database.tables.Role;
import cn.hlvan.database.tables.RolePermission;
import cn.hlvan.database.tables.System;
import cn.hlvan.database.tables.User;
import cn.hlvan.database.tables.UserRole;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in super
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>super.brand</code>.
     */
    public static final Brand BRAND = cn.hlvan.database.tables.Brand.BRAND;

    /**
     * The table <code>super.brand_classify</code>.
     */
    public static final BrandClassify BRAND_CLASSIFY = cn.hlvan.database.tables.BrandClassify.BRAND_CLASSIFY;

    /**
     * The table <code>super.goods</code>.
     */
    public static final Goods GOODS = cn.hlvan.database.tables.Goods.GOODS;

    /**
     * The table <code>super.goods_classify</code>.
     */
    public static final GoodsClassify GOODS_CLASSIFY = cn.hlvan.database.tables.GoodsClassify.GOODS_CLASSIFY;

    /**
     * The table <code>super.permission</code>.
     */
    public static final Permission PERMISSION = cn.hlvan.database.tables.Permission.PERMISSION;

    /**
     * The table <code>super.product</code>.
     */
    public static final Product PRODUCT = cn.hlvan.database.tables.Product.PRODUCT;

    /**
     * The table <code>super.role</code>.
     */
    public static final Role ROLE = cn.hlvan.database.tables.Role.ROLE;

    /**
     * The table <code>super.role_permission</code>.
     */
    public static final RolePermission ROLE_PERMISSION = cn.hlvan.database.tables.RolePermission.ROLE_PERMISSION;

    /**
     * The table <code>super.system</code>.
     */
    public static final System SYSTEM = cn.hlvan.database.tables.System.SYSTEM;

    /**
     * The table <code>super.user</code>.
     */
    public static final User USER = cn.hlvan.database.tables.User.USER;

    /**
     * The table <code>super.user_role</code>.
     */
    public static final UserRole USER_ROLE = cn.hlvan.database.tables.UserRole.USER_ROLE;
}

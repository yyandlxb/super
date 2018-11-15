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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Super extends SchemaImpl {

    private static final long serialVersionUID = 496597367;

    /**
     * The reference instance of <code>super</code>
     */
    public static final Super SUPER = new Super();

    /**
     * The table <code>super.brand</code>.
     */
    public final Brand BRAND = cn.hlvan.database.tables.Brand.BRAND;

    /**
     * The table <code>super.brand_classify</code>.
     */
    public final BrandClassify BRAND_CLASSIFY = cn.hlvan.database.tables.BrandClassify.BRAND_CLASSIFY;

    /**
     * The table <code>super.goods</code>.
     */
    public final Goods GOODS = cn.hlvan.database.tables.Goods.GOODS;

    /**
     * The table <code>super.goods_classify</code>.
     */
    public final GoodsClassify GOODS_CLASSIFY = cn.hlvan.database.tables.GoodsClassify.GOODS_CLASSIFY;

    /**
     * The table <code>super.permission</code>.
     */
    public final Permission PERMISSION = cn.hlvan.database.tables.Permission.PERMISSION;

    /**
     * The table <code>super.product</code>.
     */
    public final Product PRODUCT = cn.hlvan.database.tables.Product.PRODUCT;

    /**
     * The table <code>super.role</code>.
     */
    public final Role ROLE = cn.hlvan.database.tables.Role.ROLE;

    /**
     * The table <code>super.role_permission</code>.
     */
    public final RolePermission ROLE_PERMISSION = cn.hlvan.database.tables.RolePermission.ROLE_PERMISSION;

    /**
     * The table <code>super.system</code>.
     */
    public final System SYSTEM = cn.hlvan.database.tables.System.SYSTEM;

    /**
     * The table <code>super.user</code>.
     */
    public final User USER = cn.hlvan.database.tables.User.USER;

    /**
     * The table <code>super.user_role</code>.
     */
    public final UserRole USER_ROLE = cn.hlvan.database.tables.UserRole.USER_ROLE;

    /**
     * No further instances allowed
     */
    private Super() {
        super("super", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Brand.BRAND,
            BrandClassify.BRAND_CLASSIFY,
            Goods.GOODS,
            GoodsClassify.GOODS_CLASSIFY,
            Permission.PERMISSION,
            Product.PRODUCT,
            Role.ROLE,
            RolePermission.ROLE_PERMISSION,
            System.SYSTEM,
            User.USER,
            UserRole.USER_ROLE);
    }
}

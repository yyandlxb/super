package cn.hlvan.pc.amdin.controller;

import cn.hlvan.database.tables.records.BrandRecord;
import cn.hlvan.pc.util.Page;
import cn.hlvan.pc.util.Reply;
import cn.hlvan.service.admin.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static cn.hlvan.database.Tables.BRAND;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {

    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @RequestMapping("/index")
    public String indexBrand() {

        return "brand";
    }

    @RequestMapping("/create")
    @ResponseBody
    public Reply createBrand(String name) {
        boolean brand = brandService.createBrand(name);
        if (brand ){
            return Reply.success();
        }else {
            return Reply.fail();
        }

    }

    @RequestMapping("/list")
    @ResponseBody
    public Reply listBrand(Pageable pageable,String name) {
        List<Condition> conditions = new ArrayList<>();
        if (StringUtils.isNotBlank(name))
            conditions.add(BRAND.NAME.contains(name));

        Integer total = dsl.selectCount().from(BRAND).where(conditions).fetchOne().value1();
        List<BrandRecord> fetch = dsl.select(BRAND.fields()).from(BRAND).where(conditions)
                                     .limit((int) pageable.getOffset(), pageable.getPageSize())
                                     .fetchInto(BrandRecord.class);
        return Reply.success().data(new Page<>(fetch, pageable, total));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Reply delete(Integer id,Boolean status) {
        Boolean delete = brandService.delete(id, status);
        if (delete){
            return Reply.success();
        }else {
            return Reply.fail();
        }

    }

    @RequestMapping("/detail")
    @ResponseBody
    public Reply detail(Integer id) {
        BrandRecord brandRecord = dsl.selectFrom(BRAND).where(BRAND.ID.eq(id)).fetchSingle();
        return Reply.success().data(brandRecord);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Reply update(Integer id, String name) {
        BrandRecord brandRecord = new BrandRecord();
        brandRecord.setName(name);
        brandRecord.setId(id);
        boolean update = brandService.update(brandRecord);
        if (update){
            return Reply.success();
        }else {
            return Reply.fail();
        }
    }
}

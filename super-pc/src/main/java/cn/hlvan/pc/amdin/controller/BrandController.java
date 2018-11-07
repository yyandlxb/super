package cn.hlvan.pc.amdin.controller;

import cn.hlvan.database.tables.records.BrandRecord;
import cn.hlvan.pc.util.Reply;
import cn.hlvan.service.admin.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Reply createBrand(String brandName) {
        boolean brand = brandService.createBrand(brandName);
        if (brand ){
            return Reply.success();
        }else {
            return Reply.fail();
        }

    }

    @RequestMapping("/list")
    @ResponseBody
    public Map listBrand(int start, int length, int draw, HttpServletRequest request) {
        String parameter = request.getParameter("search[value]");
        List<Condition> conditions = new ArrayList<>();
        if (StringUtils.isNotBlank(parameter))
            conditions.add(BRAND.NAME.contains(parameter));

        Integer count = dsl.selectCount().from(BRAND).where(conditions).fetchOneInto(Integer.class);
        Result<Record> fetch = dsl.select(BRAND.fields()).from(BRAND).where(conditions).limit(start, length).fetch();
        List<BrandRecord> into = fetch.into(BrandRecord.class);
        Map<String, Object> map = new HashMap<>();

        map.put("data", into);
        map.put("recordsTotal", count);
        map.put("recordsFiltered", count);
        map.put("draw", draw);
        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Reply delete(Integer[] brandIds) {
        brandService.delete(brandIds);
        return Reply.success();

    }

    @RequestMapping("/start")
    @ResponseBody
    public Reply start(Integer[] brandIds) {
        brandService.start(brandIds);
        return Reply.success();

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

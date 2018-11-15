package cn.hlvan.pc.amdin.controller;

import cn.hlvan.pc.util.Reply;
import cn.hlvan.pc.view.ClassifyList;
import cn.hlvan.service.admin.ClassifyService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static cn.hlvan.database.tables.GoodsClassify.GOODS_CLASSIFY;

@Controller
@RequestMapping("/admin/classify")
public class ClassifyController {

    private ClassifyService classifyService;
    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }
    @Autowired
    public void setClassifyService(ClassifyService classifyService) {
        this.classifyService = classifyService;
    }

    @RequestMapping("/index")
    public String indexClassify() {
        return "classify";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<ClassifyList> list  () {
        List<ClassifyList> classifyLists = dsl.select(GOODS_CLASSIFY.ID, GOODS_CLASSIFY.NAME,
            GOODS_CLASSIFY.P_ID.as("pId")).from(GOODS_CLASSIFY)
                                              .where(GOODS_CLASSIFY.ENABLED.eq(true))
                                              .fetchInto(ClassifyList.class);
        return classifyLists;

    }

    @RequestMapping("/create")
    @ResponseBody
    public Reply create(@RequestParam String name,Integer pId) {
        boolean b = classifyService.create(name,pId);
        if (b){
            return Reply.success();
        }else {
            return Reply.fail();
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Reply update(String name,@RequestParam Integer id) {
        boolean b = classifyService.update(name,id);
        if (b){
            return Reply.success();
        }else {
            return Reply.fail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Reply delete(@RequestParam Integer id) {
        boolean b = classifyService.delete(id);
        if (b){
            return Reply.success();
        }else {
            return Reply.fail();
        }
    }
}

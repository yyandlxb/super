package cn.hlvan.pc.amdin.controller;

import cn.hlvan.pc.util.Reply;
import cn.hlvan.service.admin.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/classify")
public class ClassifyController {

    private ClassifyService classifyService;

    @Autowired
    public void setClassifyService(ClassifyService classifyService) {
        this.classifyService = classifyService;
    }

    @RequestMapping("/index")
    public String indexClassify() {
        return "classify";
    }

    @RequestMapping("/create")
    @ResponseBody
    public Reply create(String name) {
        boolean b = classifyService.create(name);
        if (b){
            return Reply.success();
        }else {
            return Reply.fail();
        }
    }
}

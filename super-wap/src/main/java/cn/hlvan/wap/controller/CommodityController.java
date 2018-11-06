package cn.hlvan.wap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wap/commodity")
public class CommodityController {

    @RequestMapping("/index")
    public String home(String name){
        return "index";
    }

}

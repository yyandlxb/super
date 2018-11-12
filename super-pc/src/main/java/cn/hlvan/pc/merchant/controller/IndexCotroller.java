package cn.hlvan.pc.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/merchant")
public class IndexCotroller {

    @RequestMapping("/index")
    public String index(){
        return "/merchant/index";
    }
}

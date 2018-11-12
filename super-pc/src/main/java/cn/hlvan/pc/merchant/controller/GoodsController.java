package cn.hlvan.pc.merchant.controller;

import cn.hlvan.pc.util.Reply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("merchantGoodsController")
@RequestMapping("/merchant/goods")
public class GoodsController {



    @RequestMapping("/view")
    public String view(){

        return "/merchant/goods";
    }
}

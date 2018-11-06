package cn.hlvan.wap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wap")
public class SuperWapController {

    @RequestMapping("/{index}")
    public String home(@PathVariable("index") String index){
        return index;
    }

}

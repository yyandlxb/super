package cn.hlvan.pc.amdin.controller;

import cn.hlvan.pc.util.Reply;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @PostMapping("/login")
    public Reply login(String userName,String password){

        return Reply.success();
    }
    @GetMapping("/info")
    public Reply info(String totken){

        return Reply.success();
    }
}

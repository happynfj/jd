package cn.nfg.mweb.controller;

import cn.nfj.mservice.UserService;
import cn.nfj.mservice.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:25
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/user")
    public String getUser(){
        return "helloworld";
    }
}

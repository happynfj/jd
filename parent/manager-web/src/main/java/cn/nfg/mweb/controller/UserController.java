package cn.nfg.mweb.controller;

import cn.nfg.mservice.UserService;
import cn.nfg.mservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:25
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(){
        return userService.getUser();
    }

    @RequestMapping("/index")
    public String index(){
        return "admin";
    }

    @RequestMapping("/list")
    public String getList(){
        return "tree";
    }

}

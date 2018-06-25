package cn.nfg.mweb.controller;

import cn.nfj.mservice.UserService;
import cn.nfj.mservice.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:25
 * @Description:
 */
@Controller
public class UserController {

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

    @RequestMapping("/goodsList")
    public String goodsList(){
        return "itemList";
    }

    @RequestMapping("/item/page")
    public String itemPage(){
        return "itemList";
    }

    @RequestMapping("/item/form")
    public String itemForm(){
        return "itemForm";
    }
}

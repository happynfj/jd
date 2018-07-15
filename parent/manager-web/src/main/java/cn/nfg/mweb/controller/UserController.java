package cn.nfg.mweb.controller;

import cn.nfj.mservice.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:25
 * @Description:
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String getUser(){
        return "helloworld";
    }

    @RequestMapping("/user/login")
    public Object login(String username, String password){
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        return Result.Success();
    }

    @RequestMapping("/logout")
    public String logout(){
        return null;
    }
}

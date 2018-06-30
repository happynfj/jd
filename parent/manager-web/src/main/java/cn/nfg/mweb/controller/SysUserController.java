package cn.nfg.mweb.controller;

import cn.nfj.mservice.entity.SysUser;
import cn.nfj.mservice.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/6/27 18:18
 * @Description:
 */
@RestController
@RequestMapping("/sys")
public class SysUserController {

    @RequestMapping("/login")
    public Object login(SysUser user){
        System.out.println(user);
        return Result.Success();
    }
}

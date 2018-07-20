package cn.nfg.mweb.controller;

import cn.nfj.mservice.entity.SysUser;
import cn.nfj.mservice.service.sys.IndexService;
import cn.nfj.mservice.service.sys.MenuService;
import cn.nfj.mservice.service.sys.SysUserOnlineService;
import cn.nfj.mservice.entity.SysMenu;
import cn.nfj.mservice.entity.SysUserOnline;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import com.wf.captcha.utils.CaptchaUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/11 17:46
 * @Description:
 */
@Controller
public class IndexController {
    @Reference
    private MenuService menuService;
    @Reference
    private SysUserOnlineService sysUserOnlineService;
    @Reference
    private IndexService indexService;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request){
        SysUserOnline online = (SysUserOnline) request.getSession().getAttribute("online");
        if(online != null){
            System.out.println(online.getSessionid());
            SysUserOnline onlineUP = sysUserOnlineService.selectByPrimaryKey(online.getSessionid());
            if(onlineUP !=null){
                onlineUP.setLastAccessTime(new Date());
                sysUserOnlineService.updateByPrimaryKeySelective(onlineUP);
            }else {
                sysUserOnlineService.insertSelective(online);
            }
        }
        List<SysMenu> menuList =  menuService.getMenuList();
        model.addAttribute("menuList",menuList);
        return "index";
    }

    /**
     * 生成图形验证码
     */
    @RequestMapping("/assets/captcha")
    public void captcha(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) {
        CaptchaUtil captcha = new CaptchaUtil(130, 38, 5);
        try {
            captcha.out(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录验证
     */
    @RequestMapping("sys/login")
    public Object login(String username,String password,String code,HttpServletRequest req){
        CaptchaUtil captcha = new CaptchaUtil();
        if (captcha == null || !captcha.ver(code.toLowerCase(), req)) {
            return Result.Error("验证码不正确");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException ice){
            return Result.Error("密码错误");
        }catch (UnknownAccountException uae){
            return Result.Error("账户不存在");
        }
        req.getSession().setAttribute("user",new SysUser());
        return Result.Success();
    }
}

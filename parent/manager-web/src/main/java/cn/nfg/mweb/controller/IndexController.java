package cn.nfg.mweb.controller;

import cn.nfj.mservice.service.sys.IndexService;
import cn.nfj.mservice.service.sys.MenuService;
import cn.nfj.mservice.service.sys.SysUserOnlineService;
import cn.nfj.mservice.entity.SysMenu;
import cn.nfj.mservice.entity.SysUserOnline;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

package cn.nfg.mweb.controller;

import cn.nfj.mservice.MenuService;
import cn.nfj.mservice.entity.SysMenu;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/")
    public String index(Model model){
        List<SysMenu> menuList = menuService.getMenuList();
        model.addAttribute("menuList",menuList);
        return "index";
    }
}

package cn.nfg.mweb.controller;

import cn.nfj.mservice.service.mall.ItemService;
import cn.nfj.mservice.dto.TbItemEditDto;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2018/6/26 09:40
 * @Description:
 */
@Controller
public class PageController {
    @Reference
    private ItemService itemService;

    /**
     * 欢迎页
     */
    @RequestMapping("/welcome")
    public String welcom() {
        return "welcome";
    }

    //====================Item Begin============================

    @RequestMapping("/item/pageList")
    public String itemList() {
        return "item/list";
    }

    @RequestMapping("/item/pageEdit")
    public String itemForm() {
        return "item/edit";
    }

    @RequestMapping("item/pageAdd")
    public String itemAdd(String id, String isEdit, Model model) {
        TbItemEditDto itemEditDto = null;
        if (isEdit.equals("1")) {
            itemEditDto = itemService.getItemEditDto(id);
        }
        model.addAttribute("id", id);
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("dto", itemEditDto);
        return "item/add";
    }

    //====================Item END================================

    @RequestMapping("itemcat/tree")
    public String catTree() {
        return "item/catTree";
    }


    /**
     * 登录页
     */
    @RequestMapping("user/Pagelogin")
    public String loginPage() {
        return "login2";
    }

    @RequestMapping("dept/page")
    public String debtPage() {
        return "dept/dept";
    }

//==============================SYS  Begin=============================

    /**
     * 在线用户列表
     */
    @RequestMapping("user/online")
    public String userOnline() {
        return "sys/user-online";
    }
//==========================SYS  End=================================

}

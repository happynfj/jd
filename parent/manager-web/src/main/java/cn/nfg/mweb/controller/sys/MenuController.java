package cn.nfg.mweb.controller.sys;

import cn.nfj.mservice.service.sys.MenuService;
import cn.nfj.mservice.dto.MenuDto;
import cn.nfj.mservice.entity.SysMenu;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/11 17:45
 * @Description:
 */
@Controller
public class MenuController {
    @Reference
    private MenuService menuService;

    @RequestMapping("/page/menu")
    public Object pageMenu(){
        return "sys/menu";
    }

    @RequestMapping("/menu/list")
    @ResponseBody
    public Object menuList(){
        List dtoList = menuService.menuList();
        return Result.Success(dtoList);
    }

    @RequestMapping("/menu/one")
    @ResponseBody
    public Object getMenuById(Integer id){
        MenuDto dto = menuService.getMenuById(id);
        return Result.Success(dto);
    }

    /**
     * 编辑或保存
     */
    @RequestMapping("/menu/save")
    @ResponseBody
    public Object save(SysMenu menu){
        menuService.save(menu);
        return Result.Success();
    }
}

package cn.nfj.mservice;

import cn.nfj.mservice.dto.MenuDto;
import cn.nfj.mservice.dto.MenuTreeDto;
import cn.nfj.mservice.entity.SysMenu;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/11 17:47
 * @Description:
 */
public interface MenuService {
    List<SysMenu> getMenuList();

    List<MenuTreeDto> menuList();

    MenuDto getMenuById(Integer id);

    void save(SysMenu menu);
}

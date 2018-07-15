package cn.nfj.mservice.serviceimpl;

import cn.nfj.mservice.MenuService;
import cn.nfj.mservice.dto.MenuDto;
import cn.nfj.mservice.dto.MenuTreeDto;
import cn.nfj.mservice.entity.SysMenu;
import cn.nfj.mservice.mapper.SysMenuMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/11 17:50
 * @Description:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private SysMenuMapper menuMapper;

    /**
     * 获取菜单导航栏
     */
    @Override
    public List<SysMenu> getMenuList() {
        List<SysMenu> rootList = menuMapper.getMenuByPid(0);
        for (SysMenu menu : rootList) {
            menu.setChiList(MenuTree(menu.getMenuId()));
        }
        return rootList;
    }

    private List MenuTree(Integer menuId) {
        List<SysMenu> cildList = menuMapper.getMenuByPid(menuId);
        if (cildList != null) {
            for (SysMenu menu : cildList) {
                menu.setChiList(MenuTree(menu.getMenuId()));
            }
        }
        return cildList;
    }

    /**
     * 菜单按钮权限树
     */
    @Override
    public List<MenuTreeDto> menuList() {
        List<SysMenu> menuList = menuMapper.getAllMenu();
        List<MenuTreeDto> dtoList = new ArrayList<MenuTreeDto>();
        for (SysMenu menu : menuList) {
            dtoList.add(MenuTreeDto.adapt(menu));
        }
        return dtoList;
    }

    /**
     * 菜单单个查询
     *
     * @param id
     * @return
     */
    @Override
    public MenuDto getMenuById(Integer id) {
        SysMenu menu = menuMapper.selectByPrimaryKey(id);
        SysMenu menuP = menuMapper.selectByPrimaryKey(menu.getParentId());
        MenuDto dto;
        if (menuP == null) {
            dto = MenuDto.adapt(menu, null);
        } else {
            dto = MenuDto.adapt(menu, menuP.getMenuName());
        }
        return dto;
    }

    /**
     * 编辑或者增加
     * @param menu
     */
    @Override
    public void save(SysMenu menu) {
        //编辑
        if(menu.getParentId() == null){
            menuMapper.updateByPrimaryKeySelective(menu);
        }else {
        //增加
            menuMapper.insertSelective(menu);
        }
    }
}

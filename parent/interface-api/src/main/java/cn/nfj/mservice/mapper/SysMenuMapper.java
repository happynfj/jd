package cn.nfj.mservice.mapper;

import cn.nfj.mservice.entity.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getMenuByPid(Integer pId);

    List<SysMenu> getAllMenu();
}
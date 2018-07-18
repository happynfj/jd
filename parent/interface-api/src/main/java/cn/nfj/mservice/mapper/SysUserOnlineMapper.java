package cn.nfj.mservice.mapper;

import cn.nfj.mservice.entity.SysUserOnline;

import java.util.List;

public interface SysUserOnlineMapper {
    int deleteByPrimaryKey(String sessionid);

    int insert(SysUserOnline record);

    int insertSelective(SysUserOnline record);

    SysUserOnline selectByPrimaryKey(String sessionid);

    int updateByPrimaryKeySelective(SysUserOnline record);

    int updateByPrimaryKey(SysUserOnline record);

    List<SysUserOnline> selectAll();

    Integer selectCount();
}
package cn.nfj.mservice.service.sys;

import cn.nfj.mservice.entity.SysUserOnline;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/18 14:29
 * @Description:
 */
public interface SysUserOnlineService {
    void saveOnline(SysUserOnline online);

    Object list(Integer page, Integer rows);

    SysUserOnline selectByPrimaryKey(String sessionid);

    void updateByPrimaryKeySelective(SysUserOnline onlineUP);

    void insertSelective(SysUserOnline online);
}

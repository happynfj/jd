package cn.nfj.mservice;

import cn.nfj.mservice.entity.TbUser;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:17
 * @Description:
 */
public interface UserService {
    //User getUser();

    TbUser getPassword(String username);
}

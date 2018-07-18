package cn.nfj.mservice.serviceimpl.sys;

import cn.nfj.mservice.service.sys.UserService;
import cn.nfj.mservice.entity.TbUser;
import cn.nfj.mservice.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:00
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public TbUser getPassword(String username) {
        return userMapper.getPassword(username);
    }
}

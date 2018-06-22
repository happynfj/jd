package cn.nfj.mservice.serviceimpl;

import cn.nfg.mservice.UserService;
import cn.nfg.mservice.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:00
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        User user = new User();
        user.setUsername("nifangjie");
        user.setPassword("password");
        return user;
    }
}

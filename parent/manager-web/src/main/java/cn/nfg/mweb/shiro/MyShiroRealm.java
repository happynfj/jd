package cn.nfg.mweb.shiro;

import cn.nfj.mservice.UserService;
import cn.nfj.mservice.entity.TbUser;
import cn.nfj.mservice.mapper.TbUserMapper;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: Administrator
 * @Date: 2018/7/10 09:51
 * @Description:
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Reference
    private UserService userService;
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        //TbUser user = userService.getPassword(username);
        TbUser user = null;
        if(username.equals("admin")){

        }
        user = new TbUser();
        user.setUsername("admin");
        user.setPassword("admin");
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

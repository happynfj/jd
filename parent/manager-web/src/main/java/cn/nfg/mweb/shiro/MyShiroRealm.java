package cn.nfg.mweb.shiro;

import cn.nfj.mservice.entity.SysUser;
import cn.nfj.mservice.service.sys.SysUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.*;
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

    @Autowired
    private SysUserService sysUserService;
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String username = (String) token.getPrincipal();
        SysUser user = sysUserService.selectUserByUsername(username);
        if(user == null){
            // 账号不存在
            throw new UnknownAccountException();
        }
        if(!user.getStatus().equals(0) ){
            // 账号被锁定
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(),getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

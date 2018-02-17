package com.sephiroth.jpademo.shiro;

import com.sephiroth.jpademo.entity.EntitySysRole;
import com.sephiroth.jpademo.entity.EntitySysUser;
import com.sephiroth.jpademo.service.ServiceSysJurisdiction;
import com.sephiroth.jpademo.service.ServiceSysRole;
import com.sephiroth.jpademo.service.ServiceSysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 16:02 2018/2/16
 * @Modified By:
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ServiceSysUser serviceSysUser;

    @Autowired
    private ServiceSysRole serviceSysRole;

    @Autowired
    private ServiceSysJurisdiction serviceSysJurisdiction;

    /**
     *  @Author: 吴占超
     *  @Description: 用户授权登陆验证
     *  @Date:  20:53 2018/2/16
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        // System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        // 获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        // System.out.println(token.getCredentials());
        // 通过username从数据库中查找 User对象，没找到 返回null.
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        EntitySysUser userInfo = serviceSysUser.findByUserName(username);

        if(userInfo == null){
            return null;
        }
        return new SimpleAuthenticationInfo(
                userInfo, //用户对象
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getPassword()),//salt=username+salt
                getName()  //realm name
        );
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //用户名
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        //根据用户名来添加相应的权限和角色
        if (StringUtils.isEmpty(username)) return null;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        serviceSysRole.findByUser(username).forEach(p-> {
            info.addRole(p.getRoleName());
        });
        serviceSysJurisdiction.findByUserName(username).forEach(p -> {
            info.addStringPermission(p.getJurPath());
        });
        return info;

    }
}

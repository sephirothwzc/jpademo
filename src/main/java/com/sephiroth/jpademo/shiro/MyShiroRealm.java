package com.sephiroth.jpademo.shiro;

import com.sephiroth.jpademo.entity.EntitySysRole;
import com.sephiroth.jpademo.entity.EntitySysUser;
import com.sephiroth.jpademo.service.ServiceSysJurisdiction;
import com.sephiroth.jpademo.service.ServiceSysRole;
import com.sephiroth.jpademo.service.ServiceSysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
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
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String username = (String)token.getPrincipal(); //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码
        EntitySysUser userInfo = serviceSysUser.findByUserName(username);
        String md5Pwd=new Md5Hash(password,username).toString();
        if(userInfo == null || !username.equals(userInfo.getUserName())) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!md5Pwd.equals(userInfo.getPassword())) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个 AuthenticationInfo 实现;
        return new SimpleAuthenticationInfo(username, password, getName());

        // #region
//        // System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
//        // 获取用户的输入的账号.
//        String username = (String)token.getPrincipal();
//        // System.out.println(token.getCredentials());
//        // 通过username从数据库中查找 User对象，没找到 返回null.
//        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//
//
//        if(userInfo == null){
//            return null;
//        }
//        // 判断用户状态 可以根据最后登陆时间控制 延时登陆防止暴力破解
//
//        // 更新用户最后登陆时间
//
//        // 加密（md5+盐），返回一个32位的字符串小写
//        // String md5Pwd=new Md5Hash(userInfo.getPassword(),userInfo.getSalt()).toString();
//        return new SimpleAuthenticationInfo(
//                userInfo, //用户对象
//                userInfo.getPassword(), //密码
//                // ByteSource.Util.bytes(md5Pwd),//salt=username+salt
//                getName()  //realm name
//        );
        // #endregion
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
        // (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。ß
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(principalCollection);
            SecurityUtils.getSubject().logout();
            return null;
        }
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

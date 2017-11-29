package com.exam.system.test.common.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @packageName：com.exam.system.test.common.shiro
 * @desrciption:
 * @author: gaowei
 * @date： 2017/11/28 21:27
 * @history: (version) author date desc
 */
public class LoginRealm  extends AuthenticatingRealm{

    // logger
    private static final Logger log = LoggerFactory.getLogger(LoginRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       log.debug("进入 realm {}", token);
        // 1. 把AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        // 2. 从UsernamePasswordToken 中获取userName
        String userName = upToken.getUsername();
        log.debug("登录用户信息UserName:{}, password:{}", userName, upToken.getPassword());
        // 3. 调用数据库的方法，从数据库中查询username 对应的记录
        log.debug("从数据库中获取UserName：{} 对应的用户信息.", userName);
        // 4. 若用于不存在， 则可以抛出UnknownAccountException 异常
        if ("unknown".equals(userName)) {
            throw new UnknownAccountException("用户信息不存在！");
        }
        // 5. 根据用户信息的情况，决定是否需要抛出其它的AuthenticationException 异常
        if ("other".equals(userName)) {
            throw new LockedAccountException("用户被锁定！");
        }
        // 6. 根据用户情况，来构建AuthenticationInfo 对象并返回, 通常使用的实现类SimpleAuthenticationInfo
        /**
         * 创建SimpleAuthenticationInfo入参分析，一般采用三个参数入参创建对象
         * SimpleAuthenticationInfo(Object principal, Object credentials, String realmName)
         * principal：认证信息，可以是username，也可以是数据表对应的用户实体对象.
         * credentials：密码.
         * credentialsSalt：当前realm对象的name，调用父类的getName()方法即可.
         */
        Object principal = userName;
        Object credentials = "123456";
        String realmName = getName();

        /**
         * 登录用户名密码是交给Shiro完成，只需要将登录realm和从数据库中获取的密码
         */
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, realmName);

        return authenticationInfo;
    }
}

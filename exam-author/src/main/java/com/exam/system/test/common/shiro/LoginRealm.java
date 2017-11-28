package com.exam.system.test.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * @packageName：com.exam.system.test.common.shiro
 * @desrciption:
 * @author: gaowei
 * @date： 2017/11/28 21:27
 * @history: (version) author date desc
 */
public class LoginRealm  extends AuthenticatingRealm{
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("进入realm：" + token.hashCode());
        return null;
    }
}

package com.exam.system.test.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * @packageName：com.exam.system.test.common.shiro
 * @desrciption: 自定义Realm实现
 * @author: gaowei
 * @date： 2017-11-08 11:27
 * @history: (version) author date desc
 */
public class TestAutoRealm implements Realm{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return false;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}

package com.exam.system.test.common.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @packageName：com.exam.system.test.common.shiro
 * @desrciption: 自定义realm2
 * @author: gaowei
 * @date： 2017/11/25 21:47
 * @history: (version) author date desc
 */
public class MyRealm2 implements Realm {

    @Override
    public String getName() {
        return "realm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if (!"zhangsan".equals(username)) {
            throw new UnknownAccountException();
        }
        if (!"123456".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}

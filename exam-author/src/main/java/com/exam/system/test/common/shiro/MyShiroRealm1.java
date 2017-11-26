package com.exam.system.test.common.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @packageName：com.exam.system.test.common.shiro
 * @desrciption: 自定义Realm
 * @author: gaowei
 * @date： 2017/11/25 21:07
 * @history: (version) author date desc
 */
public class MyShiroRealm1  implements Realm{

    @Override
    public String getName() {
        return "myshiroRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); // 用户名
        String password = new String((char[]) authenticationToken.getCredentials());// 密码
        if (!"gaowei".equals(username)) {
            // 用户名错误
            throw new UnknownAccountException();
        }
        if (!"123456".equals(password)) {
            // 用户密码错误
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}

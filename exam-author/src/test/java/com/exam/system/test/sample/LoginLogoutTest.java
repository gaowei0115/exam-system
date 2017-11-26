package com.exam.system.test.sample;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;


/**
 * @packageName：com.exam.system.test.sample
 * @desrciption: 模拟shiro登录登出验证
 * @author: gaowei
 * @date： 2017/11/25 20:52
 * @history: (version) author date desc
 */
public class LoginLogoutTest {


    @Test
    public void testHelloWorld() {
        // 1. 获取SecurityManager验证工厂 ,指定classpath下的ini配置文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        // 2. 获取SecurityManager实例，并绑定给SecurityUtils
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        //3. 得到Subject及创建用户名和密码验证Token（用户登录凭证）
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("gaowei", "12345");

        try {
            subject.login(token);
        } catch (Exception e) {
            System.out.println("登录验证失败！");
        }

        Assert.assertEquals(true, subject.isAuthenticated());

        // 退出
        subject.logout();
    }

    @Test
    public void testCustomRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("gaowei", "123456");

        try {
            subject.login(token);
        } catch (Exception e) {
            System.out.println("登录验证失败");
        }

        Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();
    }

    @Test
    public void testMultiCustomRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");

        SecurityManager manager = factory.getInstance();

        SecurityUtils.setSecurityManager(manager);

        Subject subject = SecurityUtils.getSubject();

        String username = "zhangsan1";
        String password = "123456";

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
        } catch (Exception e) {
            System.out.println("用户登录验证失败");
        }

        Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();
    }

    @Test
    public void testJdbcRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("gaowei", "123456");

        try {
            subject.login(token);
        } catch (Exception  e) {
            System.out.println("用户登录失败");
        }

        Assert.assertEquals(true, subject.isAuthenticated());
        System.out.println("登录成功");

        subject.logout();
    }
}

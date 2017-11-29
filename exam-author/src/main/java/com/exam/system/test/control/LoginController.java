package com.exam.system.test.control;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

/**
 * @packageName：com.exam.system.test.control
 * @desrciption:
 * @author: gaowei
 * @date： 2017/11/28 21:19
 * @history: (version) author date desc
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @RequestMapping(value = "/toLogin", method=RequestMethod.GET)
    public String toLogin() {
        return "login";
    }


    @RequestMapping(value = "/toUser", method = RequestMethod.GET)
    public String toUser() {
        return "user";
    }

    @RequestMapping(value = "/login", method={RequestMethod.POST})
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            token.setRememberMe(true);
            try {
                System.out.println("执行登录....");
                System.out.println(token.hashCode());
                subject.login(token);
            } catch (Exception e) {
                System.out.println("登录失败：" + e.getMessage());
            }
        }
        return "redirect:/login/toList";
    }

    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList() {
        return "list";
    }
}

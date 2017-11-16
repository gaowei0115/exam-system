package com.exam.system.manager.system.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.system.control
 * @desrciption: 用户登录Controller
 * @author: gaowei
 * @date： 2017-11-16 15:37
 * @history: (version) author date desc
 */
@Controller
public class LoginController {

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/toLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String toLogin() {
        return "login";
    }

}

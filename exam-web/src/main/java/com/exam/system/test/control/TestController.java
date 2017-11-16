package com.exam.system.test.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.test.control
 * @desrciption: 模拟测试控制层
 * @author: gaowei
 * @date： 2017-11-13 13:27
 * @history: (version) author date desc
 */
@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/toLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String toLogin() {
        return  "login";
    }

    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping(value = "/toIndex", method = RequestMethod.POST)
    public String toList() {
        return "index";
    }

    /**
     * 跳转到统计页面
     * @return
     */
    @RequestMapping(value = "/toStatistics", method = RequestMethod.GET)
    public String toStatistics() {
        return "statistics/statistics";
    }
}

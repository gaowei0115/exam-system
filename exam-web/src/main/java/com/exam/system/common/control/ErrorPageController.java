package com.exam.system.common.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.common.control
 * @desrciption: 错误页面指向
 * @author: gaowei
 * @date： 2017-11-13 14:24
 * @history: (version) author date desc
 */
@Controller
public class ErrorPageController {

    /**
     * 指向404错误页面
     * @return
     */
    @RequestMapping(value = "/notPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String notPage() {
        return "error/404";
    }


    /**
     * 指向500错误页面
     * @return
     */
    @RequestMapping(value = "/serverError", method = {RequestMethod.GET, RequestMethod.POST})
    public String serverError() {
        return "error/500";
    }
}

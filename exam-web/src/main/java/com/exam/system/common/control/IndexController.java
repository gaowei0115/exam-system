package com.exam.system.common.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.common.control
 * @desrciption: 主页面控制层
 * @author: gaowei
 * @date： 2017-11-17 15:15
 * @history: (version) author date desc
 */
@Controller
public class IndexController {

    /**
     * 进去主页面
     * @return
     */
    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "index";
    }

}

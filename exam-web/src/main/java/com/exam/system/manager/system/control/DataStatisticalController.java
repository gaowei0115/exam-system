package com.exam.system.manager.system.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.system.control
 * @desrciption: 系统数据统计分析Controller
 * @author: gaowei
 * @date： 2017/11/18 16:54
 * @history: (version) author date desc
 */
@RequestMapping("/data")
@Controller
public class DataStatisticalController extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(DataStatisticalController.class);

    /**
     * 跳转数据统计分析页面
     * @return
     */
    @RequestMapping(value = "/toStatistical", method = {RequestMethod.GET, RequestMethod.POST})
    public String toStatistical() {
        log.debug("进入数据统计分析页面...");
        return "statistics/statistics";
    }
}



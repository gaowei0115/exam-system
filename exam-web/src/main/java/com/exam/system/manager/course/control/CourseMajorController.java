package com.exam.system.manager.course.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.course.control
 * @desrciption: 专业管理Controller
 * @author: gaowei
 * @date： 2017/11/18 15:10
 * @history: (version) author date desc
 */
@RequestMapping("/course")
@Controller
public class CourseMajorController extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(CourseMajorController.class);

    /**
     * 跳转专业管理页面
     * @return
     */
    @RequestMapping(value = "/toExamMajor", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamMajor() {
        log.debug("进入专业管理页面...");
        return "manager_course/course_major";
    }
}

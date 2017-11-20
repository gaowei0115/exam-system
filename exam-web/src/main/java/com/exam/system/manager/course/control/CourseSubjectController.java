package com.exam.system.manager.course.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.course.control
 * @desrciption: 科目管理Controller
 * @author: gaowei
 * @date： 2017/11/18 15:13
 * @history: (version) author date desc
 */
@RequestMapping("/course")
@Controller
public class CourseSubjectController extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(CourseSubjectController.class);

    /**
     * 跳转科目管理页面
     * @return
     */
    @RequestMapping(value = "/toExamSubject", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamSubject() {
        log.debug("进入科目管理页面....");
        return "manager_course/course_subject";
    }
}

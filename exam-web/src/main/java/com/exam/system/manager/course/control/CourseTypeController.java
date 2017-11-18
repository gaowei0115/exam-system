package com.exam.system.manager.course.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import com.exam.system.manager.course.entity.ExamTypeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @packageName：com.exam.system.manager.course.control
 * @desrciption: 考试类型Controller
 * @author: gaowei
 * @date： 2017/11/17 22:35
 * @history: (version) author date desc
 */
@Controller
@RequestMapping("/course")
public class CourseTypeController extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(CourseTypeController.class);

    /**
     * 跳转到考试类型页面
     * @return
     */
    @RequestMapping(value = "/toExamType", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamType() {
        log.debug("进入考试类型管理页面...");
        return "manager_course/course_type";
    }


}

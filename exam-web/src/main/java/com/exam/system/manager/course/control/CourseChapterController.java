package com.exam.system.manager.course.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.course.control
 * @desrciption: 科目章节Controller
 * @author: gaowei
 * @date： 2017/11/18 15:17
 * @history: (version) author date desc
 */
@RequestMapping("/course")
@Controller
public class CourseChapterController extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(CourseChapterController.class);

    /**
     * 跳转科目章节管理页面
     * @return
     */
    @RequestMapping(value = "/toExamChapter", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamChapter() {
        log.debug("进入科目章节管理页面....");
        return "manager_course/course_chapters";
    }
}

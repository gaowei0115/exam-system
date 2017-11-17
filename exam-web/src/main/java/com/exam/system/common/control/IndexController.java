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

    /**
     * 跳转到考试类型
     * @return
     */
    @RequestMapping(value = "/toExamType", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamType() {
        return "manager_course/course_type";
    }

    /**
     * 跳转到考试科目
     * @return
     */
    @RequestMapping(value = "/toExamMajor", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamMajor() {
        return "manager_course/course_major";
    }

    /**
     * 跳转到考试专业
     * @return
     */
    @RequestMapping(value = "/toExamSubject", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamSubject() {
        return "manager_course/course_subject";
    }

    /**
     * 跳转到科目章节
     * @return
     */
    @RequestMapping(value = "/toExamChapter", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamChapter() {
        return "manager_course/course_chapters";
    }

}

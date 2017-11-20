package com.exam.system.manager.question.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.question.control
 * @desrciption: 题库Controller
 * @author: gaowei
 * @date： 2017/11/18 15:32
 * @history: (version) author date desc
 */
@RequestMapping("/question")
@Controller
public class QuestionController  extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(QuestionController.class);

    /**
     * 跳转题库管理页面
     * @return
     */
    @RequestMapping(value = "/toQuestion", method = {RequestMethod.GET, RequestMethod.POST})
    public String toQuestion() {
        log.debug("进入题库管理页面...");
        return "manager_question/question_list";
    }

}

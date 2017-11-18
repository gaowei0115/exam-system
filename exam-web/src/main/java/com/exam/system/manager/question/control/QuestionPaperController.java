package com.exam.system.manager.question.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.question.control
 * @desrciption: 题库试卷Controller
 * @author: gaowei
 * @date： 2017/11/18 15:40
 * @history: (version) author date desc
 */
@RequestMapping("/question")
@Controller
public class QuestionPaperController extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(QuestionPaperController.class);

    /**
     * 跳转到题库试卷管理页面
     * @return
     */
    @RequestMapping(value = "/toQuestionPaper", method = {RequestMethod.POST, RequestMethod.GET})
    public String toQuestionPaper() {
        log.debug("进入题库试卷管理页面...");
        return "manager_question/question_paper_list";
    }
}

package com.exam.system.manager.message.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import com.exam.system.manager.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.message.control
 * @desrciption: 消息管理Controller
 * @author: gaowei
 * @date： 2017/11/18 16:12
 * @history: (version) author date desc
 */
@RequestMapping("/message")
@Controller
public class MessageController extends BaseController{

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(MessageController.class);

    /**
     * 跳转反馈消息管理页面
     * @return
     */
    @RequestMapping(value = "/toBackMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public String toBackMessage() {
        log.debug("进入反馈消息管理页面...");
        return "message/feedbacklist";
    }
}

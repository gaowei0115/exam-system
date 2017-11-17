package com.exam.system.manager.system.control;

import com.exam.system.common.constant.ResultState;
import com.exam.system.common.log.impl.ControllerLogger;
import com.exam.system.manager.entity.Message;
import com.exam.system.manager.entity.ResultEntity;
import com.exam.system.manager.system.entity.UserBaseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @packageName：com.exam.system.manager.system.control
 * @desrciption: 用户登录Controller
 * @author: gaowei
 * @date： 2017-11-16 15:37
 * @history: (version) author date desc
 */
@Controller
public class LoginController {

    private static final ControllerLogger log = new ControllerLogger(LoginController.class);

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/toLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String toLogin() {
        return "login";
    }

    /**
     * 账户登录 成功跳转到主页面
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json")
    public @ResponseBody ResultEntity login(@RequestBody UserBaseEntity user) {
        // 1. 登录校验
        log.debug("登录用户：{}", user.getLoginCode());
        ResultEntity result = new ResultEntity();
        result.setStatus(ResultState.SUCCESS.getState());

        result.setMessage(new Message("0", "登录成功"));
        result.setUri("/index");
        // 2. 登录参数返回
        return result;
    }

}

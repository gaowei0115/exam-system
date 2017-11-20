package com.exam.system.manager.system.control;

import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @packageName：com.exam.system.manager.system.control
 * @desrciption: 用户管理Controller
 * @author: gaowei
 * @date： 2017/11/18 16:41
 * @history: (version) author date desc
 */
@RequestMapping("/user")
@Controller
public class UserController extends BaseController {

    /**
     * logger
     */
    private static final ControllerLogger log = new ControllerLogger(UserController.class);

    /**
     * 跳转管理员用户管理页面
     * @return
     */
    @RequestMapping(value = "/toSysUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String toSysUser() {
        log.debug("进入管理员用户管理页面...");
        return "systemmanager/user_sys_list";
    }

    /**
     * 跳转用户角色管理页面
     * @return
     */
    @RequestMapping(value = "/toUserRole", method = {RequestMethod.GET, RequestMethod.POST})
    public String toUserRole() {
        log.debug("进入用户角色管理页面...");
        return "role/role_list";
    }

    /**
     * 跳转用户角色管理页面
     * @return
     */
    @RequestMapping(value = "/toPublicUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String toPublicUser() {
        log.debug("进入普通用户管理页面...");
        return "systemmanager/user_public_list";
    }

    /**
     * 跳转用户个人中心管理页面
     * @return
     */
    @RequestMapping(value = "/toUserInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String toUserInfo() {
        log.debug("进入用户个人中心管理页面...");
        return "systemmanager/user_info";
    }
}

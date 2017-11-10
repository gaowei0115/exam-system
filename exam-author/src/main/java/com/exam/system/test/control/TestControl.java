package com.exam.system.test.control;

import com.exam.system.test.domain.TestBean;
import com.exam.system.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @packageName：com.exam.system.test.control
 * @desrciption: test
 * @author: gaowei
 * @date： 2017-11-07 14:01
 * @history: (version) author date desc
 */
@Controller
@RequestMapping("/test")
public class TestControl {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody List<TestBean> testList(@RequestBody TestBean bean) {
        List<TestBean> result = testService.queryList(bean.getId());
        System.out.println("jinru.......");
        return result;
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/toList")
    public String toList() {
        return "list";
    }
}

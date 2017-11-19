package com.exam.system.manager.course.control;

import com.exam.system.common.constant.ResultState;
import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import com.exam.system.manager.course.entity.ExamTypeEntity;
import com.exam.system.manager.course.service.ExamTypeService;
import com.exam.system.manager.entity.Message;
import com.exam.system.manager.entity.ResultEntity;
import com.exam.system.manager.entity.ViewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ExamTypeService examTypeService;

    /**
     * 跳转到考试类型页面
     * @return
     */
    @RequestMapping(value = "/toExamType", method = {RequestMethod.GET, RequestMethod.POST})
    public String toExamType() {
        log.debug("进入考试类型管理页面...");
        return "manager_course/course_type";
    }

    /**
     * 跳转到增加考试类型页面
     * @return
     */
    @RequestMapping(value = "/toAddExamType", method = {RequestMethod.POST, RequestMethod.GET})
    public String toAddExamType() {
        log.debug("进入增加考试类型管理页面...");
        return "manager_course/course_type_add";
    }

    @RequestMapping(value = "/addExamType", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultEntity addExamType(@RequestBody ExamTypeEntity examTypeEntity) {
        // 添加人... 暂模拟
        examTypeEntity.setCreator(1L);
        log.debug("增加考试类型：{}", examTypeEntity);
        int result = examTypeService.saveExamType(examTypeEntity);
        ResultEntity resultEntity = new ResultEntity();
        Message message = null;
        if (result > 0) {
            resultEntity.setStatus(ResultState.SUCCESS.getState());
            resultEntity.setMessage(new Message("0", "保存成功"));
        } else {
            resultEntity.setStatus(ResultState.FAIL.getState());
            resultEntity.setMessage(new Message("-1", "保存失败"));
        }
        return resultEntity;
    }

    @RequestMapping(value = "/examTypeList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultEntity examTypeList(@RequestBody ExamTypeEntity examTypeEntity, @RequestParam(required = true, defaultValue = "1") Integer page, Integer pageSize) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setStatus(ResultState.SUCCESS.getState());
        List<ExamTypeEntity> list = new ArrayList<>();
        ViewData<ExamTypeEntity> viewDatas = new ViewData<ExamTypeEntity>(10, list);
        resultEntity.setViewData(viewDatas);
        resultEntity.setUri("");
        return resultEntity;
    }

}

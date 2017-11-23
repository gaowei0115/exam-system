package com.exam.system.manager.course.control;

import com.exam.system.common.constant.ResultState;
import com.exam.system.common.control.BaseController;
import com.exam.system.common.log.impl.ControllerLogger;
import com.exam.system.common.utils.StringUtils;
import com.exam.system.manager.course.entity.ExamTypeEntity;
import com.exam.system.manager.course.service.ExamTypeService;
import com.exam.system.manager.entity.Message;
import com.exam.system.manager.entity.ResultEntity;
import com.exam.system.manager.entity.ViewData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        // 重定向到自考类型管理页面
        resultEntity.setUri("/course/toExamType");
        return resultEntity;
    }

    /**
     * 显示记录
     * @param examTypeEntity
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/examTypeList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultEntity examTypeList(@RequestBody ExamTypeEntity examTypeEntity, @RequestParam(required = true, defaultValue = "1") Integer page, Integer pageSize) {
        ResultEntity resultEntity = new ResultEntity();
        log.debug("考试类型查询：{}", examTypeEntity);
        // 设置分页
        PageHelper.startPage(page, pageSize);
        String search = examTypeEntity.getExamName();
        List<ExamTypeEntity> list = null;
        if (StringUtils.isBlank(search)) {
            log.debug("查询条件为空，查询所有的记录");
            list = examTypeService.queryAllTypes();
        } else {
            list = examTypeService.queryAllTypesOfCondition(examTypeEntity);
            log.debug("查询条件【examName={}】不为空，查询满足条件的记录", search);
        }
        PageInfo<ExamTypeEntity> pi = new PageInfo<>(list);
        ViewData<ExamTypeEntity> viewData = new ViewData<>(pi.getTotal(), list);
        resultEntity.setStatus(ResultState.SUCCESS.getState());
        resultEntity.setViewData(viewData);
        resultEntity.setUri("");
        return resultEntity;
    }

    /**
     * 修改自考类型
     * @param examTypeEntity
     * @return
     */
    @RequestMapping(value = "/modifyExamType", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultEntity modifyExamType(@RequestBody ExamTypeEntity examTypeEntity) {
        ResultEntity resultEntity = new ResultEntity();
        log.debug("修改考试类型：{}", examTypeEntity);
        int result = examTypeService.updateExamType(examTypeEntity);
        if (result > 0) {
            resultEntity.setStatus(ResultState.SUCCESS.getState());
            resultEntity.setMessage(new Message("0", "修改成功"));
        } else {
            resultEntity.setStatus(ResultState.FAIL.getState());
            resultEntity.setMessage(new Message("-1", "修改失败"));
        }
        // 重定向到自考类型管理页面
        resultEntity.setUri("/course/toExamType");
        return resultEntity;
    }

    /**
     * 删除自考类型
     * @param examId
     * @return
     */
    @RequestMapping(value = "/deleteExamType", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultEntity deleteExamType(@RequestParam(required = true) Long examId) {
        ResultEntity resultEntity = new ResultEntity();
        log.debug("删除考试类型，考试类型编号：{}", examId);
        int result = examTypeService.deleteExamType(examId);
        if (result > 0) {
            resultEntity.setStatus(ResultState.SUCCESS.getState());
            resultEntity.setMessage(new Message("0", "删除成功"));
        } else {
            resultEntity.setStatus(ResultState.FAIL.getState());
            resultEntity.setMessage(new Message("-1", "删除失败"));
        }
        // 重定向到自考类型管理页面
        resultEntity.setUri("/course/toExamType");
        return resultEntity;
    }

}

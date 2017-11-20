package com.exam.system.manager.course.service;

import com.exam.system.manager.course.entity.ExamTypeEntity;

/**
 * @packageName：com.exam.system.manager.course.service
 * @desrciption: 考试类型Service
 * @author: gaowei
 * @date： 2017/11/19 21:52
 * @history: (version) author date desc
 */
public interface ExamTypeService {

    /**
     * 保存考试类型
     * @param examTypeEntity
     * @return
     */
    int saveExamType(ExamTypeEntity examTypeEntity);
}
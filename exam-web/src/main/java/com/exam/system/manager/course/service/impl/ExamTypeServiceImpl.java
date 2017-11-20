package com.exam.system.manager.course.service.impl;

import com.exam.system.manager.course.entity.ExamTypeEntity;
import com.exam.system.manager.course.mapper.ExamTypeMapper;
import com.exam.system.manager.course.service.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @packageName：com.exam.system.manager.course.service.impl
 * @desrciption:
 * @author: gaowei
 * @date： 2017/11/19 21:53
 * @history: (version) author date desc
 */
@Service("examTypeServiceImpl")
public class ExamTypeServiceImpl implements ExamTypeService{

    /**
     *
     */
    @Autowired
    private ExamTypeMapper examTypeMapper;

    @Override
    public int saveExamType(ExamTypeEntity examTypeEntity) {
        if (examTypeEntity == null) {
            return 0;
        }
        examTypeEntity.setCreateTime(new Date());
        examTypeEntity.setExamEffect("0");
        return examTypeMapper.insertSelective(examTypeEntity);
    }
}

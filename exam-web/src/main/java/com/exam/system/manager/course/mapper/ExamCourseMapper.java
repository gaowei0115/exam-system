package com.exam.system.manager.course.mapper;

import com.exam.system.manager.course.entity.ExamCourseEntity;

/**
 * @desrciption: 考试科目Mapper
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public interface ExamCourseMapper {

    /**
     * 删除科目
     * @param courseId
     * @return
     */
    int deleteByPrimaryKey(Long courseId);

    /**
     * 保存科目
     * @param record
     * @return
     */
    int insert(ExamCourseEntity record);

    /**
     * 可选保存科目
     * @param record
     * @return
     */
    int insertSelective(ExamCourseEntity record);

    /**
     * 查询科目
     * @param courseId
     * @return
     */
    ExamCourseEntity selectByPrimaryKey(Long courseId);

    /**
     * 可选更新科目
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExamCourseEntity record);

    /**
     * 更新科目
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExamCourseEntity record);
}
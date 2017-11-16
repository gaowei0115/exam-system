package com.exam.system.manager.course.mapper;

import com.exam.system.manager.course.entity.ExamKindEntity;

/**
 * @desrciption: 考试专业Mapper
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public interface ExamKindMapper {

    /**
     * 根据ID删除专业信息
     * @param kindId
     * @return
     */
    int deleteByPrimaryKey(Long kindId);

    /**
     * 保存专业信息
     * @param record
     * @return
     */
    int insert(ExamKindEntity record);

    /**
     * 选择保存专业信息
     * @param record
     * @return
     */
    int insertSelective(ExamKindEntity record);

    /**
     * 根据ID查询专业信息
     * @param kindId
     * @return
     */
    ExamKindEntity selectByPrimaryKey(Long kindId);

    /**
     * 选择更新专业信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExamKindEntity record);

    /**
     * 更新专业信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExamKindEntity record);
}
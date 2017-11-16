package com.exam.system.manager.question.mapper;

import com.exam.system.manager.question.entity.ExamLibraryEntity;

/**
 * @desrciption: 考试题库Mapper
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public interface ExamLibraryMapper {

    /**
     * 删除题库
     * @param libraryId
     * @return
     */
    int deleteByPrimaryKey(Long libraryId);

    /**
     * 保存题库信息
     * @param record
     * @return
     */
    int insert(ExamLibraryEntity record);

    /**
     * 选择保存题库信息
     * @param record
     * @return
     */
    int insertSelective(ExamLibraryEntity record);

    /**
     * 查询题库信息
     * @param libraryId
     * @return
     */
    ExamLibraryEntity selectByPrimaryKey(Long libraryId);

    /**
     * 选择更新题库
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExamLibraryEntity record);

    /**
     * 更新题库
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExamLibraryEntity record);
}
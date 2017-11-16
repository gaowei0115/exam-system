package com.exam.system.manager.course.mapper;

import com.exam.system.manager.course.entity.ExamCourseChapterEntity;

/**
 * @desrciption: 考试科目章节Mapper
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public interface ExamCourseChapterMapper {

    /**
     * 删除章节信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存章节信息
     * @param record
     * @return
     */
    int insert(ExamCourseChapterEntity record);

    /**
     * 选择保存章节信息
     * @param record
     * @return
     */
    int insertSelective(ExamCourseChapterEntity record);

    /**
     * 查询章节信息
     * @param id
     * @return
     */
    ExamCourseChapterEntity selectByPrimaryKey(Long id);

    /**
     * 可选更新章节信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExamCourseChapterEntity record);

    /**
     * 更新章节信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExamCourseChapterEntity record);
}
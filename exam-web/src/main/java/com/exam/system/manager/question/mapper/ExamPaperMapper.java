package com.exam.system.manager.question.mapper;

import com.exam.system.manager.question.entity.ExamPaperEntity;

/**
 * @desrciption: 考试试卷Mapper
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public interface ExamPaperMapper {

    /**
     * 删除试卷
     * @param paperId
     * @return
     */
    int deleteByPrimaryKey(Long paperId);

    /**
     * 保存试卷
     * @param record
     * @return
     */
    int insert(ExamPaperEntity record);

    /**
     * 选择保存试卷
     * @param record
     * @return
     */
    int insertSelective(ExamPaperEntity record);

    /**
     * 查询试卷
     * @param paperId
     * @return
     */
    ExamPaperEntity selectByPrimaryKey(Long paperId);

    /**
     * 选择更新试卷
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExamPaperEntity record);

    /**
     * 更新试卷
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExamPaperEntity record);
}
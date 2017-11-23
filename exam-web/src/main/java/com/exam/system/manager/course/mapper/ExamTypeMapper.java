package com.exam.system.manager.course.mapper;

import com.exam.system.manager.course.entity.ExamTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @desrciption: 考试类型Mapper
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public interface ExamTypeMapper {

    /**
     * 根据考试类型编号删除
     * @param exam_id
     * @return
     */
    int deleteByPrimaryKey(Long exam_id);

    /**
     * 保存全部类型信息
     * @param record
     * @return
     */
    int insert(ExamTypeEntity record);

    /**
     * 选择保存考试类型信息
     * @param record
     * @return
     */
    int insertSelective(ExamTypeEntity record);

    /**
     * 根据考试类型编号查询
     * @param exam_id
     * @return
     */
    ExamTypeEntity selectByPrimaryKey(Long exam_id);

    /**
     * 查询所有的考试类型
     * @return
     */
    List<ExamTypeEntity> queryAllTypes();

    /**
     * 查询满足条件的考试类型
     * @param examTypeEntity
     * @return
     */
    List<ExamTypeEntity> queryAllTypesOfCondition(ExamTypeEntity examTypeEntity);

    /**
     * 选择更新开始类型
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExamTypeEntity record);

    /**
     * 根据考试类型编号更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExamTypeEntity record);
}
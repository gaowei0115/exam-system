package com.exam.system.test.db;

import com.exam.system.manager.course.entity.ExamTypeEntity;
import com.exam.system.manager.course.mapper.ExamTypeMapper;
import com.exam.system.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @packageName：com.exam.system.test.db
 * @desrciption:
 * @author: gaowei
 * @date： 2017-11-20 17:48
 * @history: (version) author date desc
 */
public class ExamTypeMapperTest extends BaseTest{

    @Autowired
    private ExamTypeMapper examTypeMapper;

    @Test
    public void test() {
        ExamTypeEntity examTypeEntity = new ExamTypeEntity();
        examTypeEntity.setExamName("自考");
        examTypeEntity.setExamEffect("0");
        examTypeEntity.setCreator(1L);
        examTypeEntity.setCreateTime(new Date());
        examTypeEntity.setDescription("zikao");
        examTypeMapper.insertSelective(examTypeEntity);
    }

    @Test
    public void test01() {
        List<ExamTypeEntity> list = examTypeMapper.queryAllTypes();
        System.out.println(list.size());
    }
}

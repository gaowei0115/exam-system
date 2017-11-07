package com.exam.system.test.mapper;

import com.exam.system.test.domain.TestBean;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @packageName：com.exam.system.test.mapper
 * @desrciption:
 * @author: gaowei
 * @date： 2017-11-07 16:21
 * @history: (version) author date desc
 */
@Repository
public class TestMapper {

    private static final Map<Integer, List<TestBean>> mockData = new HashMap<>();

    static {
        List<TestBean> list1 = new ArrayList<>();
        TestBean bean = new TestBean();
        bean.setId(100);
        bean.setCode("test100");
        bean.setCreate(new Date());
        bean.setDesc("testbean100des");
        list1.add(bean);
        bean = new TestBean();
        bean.setId(101);
        bean.setCode("test101");
        bean.setCreate(new Date());
        bean.setDesc("testbean101des");
        list1.add(bean);
        bean = new TestBean();
        bean.setId(102);
        bean.setCode("test102");
        bean.setCreate(new Date());
        bean.setDesc("testbean102des");
        list1.add(bean);
        bean = new TestBean();
        bean.setId(103);
        bean.setCode("test103");
        bean.setCreate(new Date());
        bean.setDesc("testbean103des");
        list1.add(bean);
        mockData.put(1, list1);

        list1 = new ArrayList<>();
        bean = new TestBean();
        bean.setId(200);
        bean.setCode("test200");
        bean.setCreate(new Date());
        bean.setDesc("testbean200des");
        list1.add(bean);
        bean = new TestBean();
        bean.setId(201);
        bean.setCode("test201");
        bean.setCreate(new Date());
        bean.setDesc("testbean201des");
        list1.add(bean);
        bean = new TestBean();
        bean.setId(202);
        bean.setCode("test202");
        bean.setCreate(new Date());
        bean.setDesc("testbean202des");
        list1.add(bean);
        bean = new TestBean();
        bean.setId(203);
        bean.setCode("test203");
        bean.setCreate(new Date());
        bean.setDesc("testbean203des");
        list1.add(bean);
        mockData.put(2, list1);
    }

    /**
     * 查询列表
     * @param id
     * @return
     */
    public List<TestBean> queryList(Integer id) {
        List<TestBean> result = mockData.get(id);
        return result;
    }
}

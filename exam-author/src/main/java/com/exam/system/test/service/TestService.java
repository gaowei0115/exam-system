package com.exam.system.test.service;

import com.exam.system.test.domain.TestBean;

import java.util.List;

/**
 * @packageName：com.exam.system.test.service
 * @desrciption: testService
 * @author: gaowei
 * @date： 2017-11-07 14:08
 * @history: (version) author date desc
 */
public interface TestService {

    /**
     * 查询列表
     * @param id
     * @return
     */
    List<TestBean> queryList(Integer id);


}

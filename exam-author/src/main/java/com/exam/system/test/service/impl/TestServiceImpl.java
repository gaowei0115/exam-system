package com.exam.system.test.service.impl;

import com.exam.system.test.domain.TestBean;
import com.exam.system.test.mapper.TestMapper;
import com.exam.system.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName：com.exam.system.test.service.impl
 * @desrciption:
 * @author: gaowei
 * @date： 2017-11-07 16:28
 * @history: (version) author date desc
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestBean> queryList(Integer id) {
        return testMapper.queryList(id);
    }
}

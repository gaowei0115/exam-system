package com.exam.system.test.db;

import com.exam.system.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * @packageName：com.exam.system.test.db
 * @desrciption: 数据源整合测试
 * @author: gaowei
 * @date： 2017-11-13 13:05
 * @history: (version) author date desc
 */
public class DataSourceTest  extends BaseTest{

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        System.out.println(dataSource);
    }
}

package com.exam.system.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @packageName：com.exam.system.test
 * @desrciption: 模拟web测试基类
 * @author: gaowei
 * @date： 2017-11-13 13:04
 * @history: (version) author date desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:dispatcher-servlet.xml"})
@WebAppConfiguration
@EnableTransactionManagement
public class BaseWebTest {

}

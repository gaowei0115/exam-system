package com.exam.system.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @packageName：com.exam.system.common.utils
 * @desrciption: Spring 应用上下文
 * @author: gaowei
 * @date： 2017-11-17 16:45
 * @history: (version) author date desc
 */
public class ApplictionFactory {

    private ApplictionFactory() {

    }

    public static ApplicationContext context() {
        return ApplicationFactoryContextHolder.applicationContext;
    }

    /**
     * 通过静态内部类实现单例模式
     */
    private static class ApplicationFactoryContextHolder {
        public static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
    }

    /**
     * 获取容器对象
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return context().getBean(name);
    }

}

package com.exam.system.common.log.impl;

import com.exam.system.common.log.ExamBaseLogger;
import com.exam.system.common.log.ExamLogger;
import com.exam.system.common.log.LoggerType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @packageName：com.exam.system.common.log.impl
 * @desrciption: 工具类日志类
 * @author: gaowei
 * @date： 2017-11-13 15:31
 * @history: (version) author date desc
 */
public class CommonLogger extends ExamBaseLogger{

    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(LoggerType.COMMON_LOGGER_TYPE);

    public CommonLogger(Logger log) {
        super(log);
    }

    public CommonLogger(Class<?> clazz, String businessName) {
        super(clazz, businessName, log);
    }

    public CommonLogger(Class<?> clazz) {
        super(clazz, log);
    }

    /**
     * 环绕日志
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        return ExamLogger.around(log, "", pjp);
    }
}

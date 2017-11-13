package com.exam.system.common.log;

/**
 * @packageName：com.exam.system.common.log
 * @desrciption: 日志输出类型
 * @author: gaowei
 * @date： 2017-11-13 15:32
 * @history: (version) author date desc
 */
public class LoggerType {

    /**
     * 系统控制层日志（Controller）
     */
    public static final String CONTROLL_LOGGER_TYPE = "exam.web.controller";

    /**
     * 系统业务层日志（Service）
     */
    public static final String SERVICE_LOGGER_TYPE = "exam.web.service";

    /**
     * 共用类日志（如：Util包）
     */
    public static final String COMMON_LOGGER_TYPE = "exam.web.common";

    /**
     * 其它日志（系统启动....）
     */
    public static final String OTHER_LOGGER_TYPE = "exam.web.other";
}

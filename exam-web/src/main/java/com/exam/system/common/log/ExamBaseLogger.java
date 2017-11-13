package com.exam.system.common.log;

import org.slf4j.Logger;

/**
 * @packageName：com.exam.system.common.log
 * @desrciption: 日志基类
 * @author: gaowei
 * @date： 2017-11-13 14:53
 * @history: (version) author date desc
 */
public class ExamBaseLogger implements IBaseLogger{

    // 日志对象
    private Logger logger;
    private String clazz;
    // 输出日志
    private final StringBuffer printMessage = new StringBuffer();

    public ExamBaseLogger() {

    }

    public ExamBaseLogger(Logger log) {
        this.logger = log;
    }

    public ExamBaseLogger(Class<?> clazz, Logger log) {
        this.clazz = "[" + clazz.getSimpleName() + "] - ";
        this.logger  = log;
        printMessage.append(this.clazz);
    }

    /**
     *
     * @param clazz
     * @param businessName
     *          业务标识码
     * @param log
     */
    public ExamBaseLogger(Class<?> clazz, String businessName, Logger log) {
        this.logger = log;
        this.clazz = "[" + clazz.getSimpleName() + "] - ";
        printMessage.append(this.clazz);
        setValue(businessName);
    }

    /**
     * 清空日志
     * @return
     */
    public ExamBaseLogger clear() {
        printMessage.delete(0, printMessage.length()).append(this.clazz);
        return this;
    }

    /**
     * 释放内存
     */
    public void release() {

    }

    /**
     * 是否debug
     * @return
     */
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * 是否error
     * @return
     */
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    /**
     * 是否warn
     * @return
     */
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    /**
     * 是否info
     * @return
     */
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public IBaseLogger debug(String msg) {
        if (isDebugEnabled()) {
            logger.debug(new StringBuffer(printMessage).append(msg).toString());
        }
        return this;
    }

    @Override
    public IBaseLogger debug(String msg, Throwable t) {
        if (isDebugEnabled()) {
            logger.debug(new StringBuffer(printMessage).append(msg).toString(), t);
        }
        return this;
    }

    @Override
    public IBaseLogger debug(String format, Object arg) {
        if(isDebugEnabled()){
            logger.debug(new StringBuffer(printMessage).append(format).toString(), arg);
        }
        return this;
    }

    @Override
    public IBaseLogger debug(String format, Object arg1, Object arg2) {
        if(isDebugEnabled()){
            logger.debug(new StringBuffer(printMessage).append(format).toString(),arg1, arg2);
        }
        return this;
    }

    @Override
    public IBaseLogger debug(String format, Object[] argArray) {
        if(isDebugEnabled()){
            logger.debug(new StringBuffer(printMessage).append(format).toString(),argArray);
        }
        return this;
    }

    @Override
    public IBaseLogger info(String msg) {
        if (isInfoEnabled()) {
            logger.info(new StringBuffer(printMessage).append(msg).toString());
        }
        return this;
    }

    @Override
    public IBaseLogger info(String msg, Throwable t) {
        if (isInfoEnabled()) {
            logger.info(new StringBuffer(printMessage).append(msg).toString(), t);
        }
        return this;
    }

    @Override
    public IBaseLogger info(String format, Object arg) {
        if (isInfoEnabled()) {
            logger.info(new StringBuffer(printMessage).append(format).toString(), arg);
        }
        return this;
    }

    @Override
    public IBaseLogger info(String format, Object arg1, Object arg2) {
        if (isInfoEnabled()) {
            logger.info(new StringBuffer(printMessage).append(format).toString(),
                    arg1, arg2);
        }
        return this;
    }

    @Override
    public IBaseLogger info(String format, Object[] argArray) {
        if (isInfoEnabled()) {
            logger.info(new StringBuffer(printMessage).append(format).toString(),
                    argArray);
        }
        return this;
    }

    @Override
    public IBaseLogger warn(String msg) {
        if (isWarnEnabled()) {
            logger.warn(new StringBuffer(printMessage).append(msg).toString());
        }
        return this;
    }

    @Override
    public IBaseLogger warn(String msg, Throwable t) {
        if (isWarnEnabled()) {
            logger.warn(new StringBuffer(printMessage).append(msg).toString(), t);
        }
        return this;
    }

    @Override
    public IBaseLogger warn(String format, Object arg) {
        if (isWarnEnabled()) {
            logger.warn(new StringBuffer(printMessage).append(format).toString(), arg);
        }
        return this;
    }

    @Override
    public IBaseLogger warn(String format, Object arg1, Object arg2) {
        if (isWarnEnabled()) {
            logger.warn(new StringBuffer(printMessage).append(format).toString(),
                    arg1, arg2);
        }
        return this;
    }

    @Override
    public IBaseLogger warn(String format, Object[] argArray) {
        if (isWarnEnabled()) {
            logger.warn(new StringBuffer(printMessage).append(format).toString(),
                    argArray);
        }
        return this;
    }

    @Override
    public IBaseLogger error(String msg) {
        if (isErrorEnabled()) {
            logger.error(new StringBuffer(printMessage).append(msg).toString());
        }
        return this;
    }

    @Override
    public IBaseLogger error(String msg, Throwable t) {
        if (isErrorEnabled()) {
            logger.error(new StringBuffer(printMessage).append(msg).toString(), t);
        }
        return this;
    }

    @Override
    public IBaseLogger error(String format, Object arg) {
        if (isErrorEnabled()) {
            logger.error(new StringBuffer(printMessage).append(format).toString(), arg);
        }
        return this;
    }

    @Override
    public IBaseLogger error(String format, Object arg1, Object arg2) {
        if (isErrorEnabled()) {
            logger.error(new StringBuffer(printMessage).append(format).toString(),
                    arg1, arg2);
        }
        return this;
    }

    @Override
    public IBaseLogger error(String format, Object[] argArray) {
        if (isErrorEnabled()) {
            logger.error(new StringBuffer(printMessage).append(format).toString(),
                    argArray);
        }
        return this;
    }

    @Override
    public IBaseLogger setValue(String businessName) {
        printMessage.append("【").append(businessName).append("】");
        return this;
    }

    public Logger getLog() {
        return logger;
    }
    public void setLog(Logger log) {
        this.logger = log;
    }
}

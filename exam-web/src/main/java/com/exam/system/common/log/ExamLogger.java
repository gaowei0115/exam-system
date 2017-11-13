package com.exam.system.common.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;

/**
 * @packageName：com.exam.system.common.log.impl
 * @desrciption: aop日志
 * @author: gaowei
 * @date： 2017-11-13 15:44
 * @history: (version) author date desc
 */
public class ExamLogger {

    public static Object around(Logger log, String desc, ProceedingJoinPoint pjp)
            throws Throwable {
        long startTime=System.currentTimeMillis();
        String startMsg = getLogApiStartMsg(pjp, desc);
        log.debug(startMsg);

        Object returnValue = pjp.proceed();
        String endMsg = getLogApiEndMsg(pjp, startTime, desc);

        log.debug(endMsg);
        return returnValue;
    }

    public static void afterThrowingAdvice(Logger log, JoinPoint point,
                                           Exception serverException) {
        String exceptionMsg = getLogExceptionMsg(point, serverException);
        log.error(exceptionMsg);
        log.error(serverException.getMessage(), serverException);
    }

    private static String getLogApiStartMsg(ProceedingJoinPoint pjp, String desc) {
        StringBuffer buffer = new StringBuffer();
        if (pjp == null) {
            return buffer.toString();
        }

        String entranceMsg = getLogEntranceMsg(pjp);
        String paramsMsg = getLogParamsMsg(pjp);

        buffer.append(entranceMsg);
        buffer.append(desc);
        buffer.append(" ....Start....");
        if (paramsMsg!=null && paramsMsg.length()>0) {
            buffer.append("\n");
            buffer.append(paramsMsg);
        }
        return buffer.toString();
    }

    private static String getLogApiEndMsg(ProceedingJoinPoint pjp, long startTime, String desc) {
        StringBuffer buffer = new StringBuffer();
        if (pjp == null) {
            return buffer.toString();
        }

        String entranceMsg = getLogEntranceMsg(pjp);
        buffer.append(entranceMsg);
        buffer.append(desc);
        buffer.append(" ....End....");
        buffer.append(" [cost time: "+(System.currentTimeMillis()-startTime)+"ms]");
        buffer.append("\n");
        return buffer.toString();
    }

    private static String getLogExceptionMsg(JoinPoint point,
                                             Exception exception) {
        StringBuffer buffer = new StringBuffer();
        if (point == null || exception == null) {
            return buffer.toString();
        }

        String entranceMsg = getLogEntranceMsg(point);
        String exceptionName = exception.getClass().getName();

        buffer.append(entranceMsg);
        buffer.append(" Hit Exception: ");
        buffer.append(exceptionName);
        buffer.append("\n");

        return buffer.toString();
    }

    private static String getLogEntranceMsg(ProceedingJoinPoint pjp) {
        String className = pjp.getTarget().getClass().getName();
        String apiName = pjp.getSignature().getName();
        return getLogEntranceMsg(className, apiName);
    }

    private static String getLogEntranceMsg(JoinPoint point) {
        String className = point.getTarget().getClass().getSimpleName();
        String apiName = point.getSignature().getName();
        return getLogEntranceMsg(className, apiName);
    }

    private static String getLogEntranceMsg(String className, String apiName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("["+className);
        buffer.append(".");
        buffer.append(apiName);
        buffer.append("()] - ");
        return buffer.toString();
    }

    private static String getLogParamsMsg(ProceedingJoinPoint pjp) {
        StringBuffer buffer = new StringBuffer();

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            @SuppressWarnings("unused")
            String paramType = null;
            if (arg != null) {
                paramType = arg.getClass().getName();
            } else {
                paramType = "NULL";
            }

            if (buffer.length() > 0) {
                buffer.append("\n");
            }
            buffer.append("    ");
            buffer.append("参数值： [" + arg + "]");
        }

        return buffer.toString();
    }
}

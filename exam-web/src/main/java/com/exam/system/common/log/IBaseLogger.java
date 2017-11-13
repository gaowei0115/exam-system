package com.exam.system.common.log;

/**
 * @packageName：com.exam.system.common.log
 * @desrciption: 日志接口
 * @author: gaowei
 * @date： 2017-11-13 14:55
 * @history: (version) author date desc
 */
public interface IBaseLogger {

    /*--------------------------------------------------------------------------debug---------------------------------*/

    public IBaseLogger debug(String msg) ;

    public IBaseLogger debug(String msg, Throwable t) ;
    public IBaseLogger debug(String format, Object arg);

    public IBaseLogger debug(String format, Object arg1, Object arg2);

    public IBaseLogger debug(String format, Object[] argArray) ;
    /*------------------------------------------------------------------------------info------------------------------*/
    public IBaseLogger info(String msg);

    public IBaseLogger info(String msg, Throwable t) ;

    public IBaseLogger info(String format, Object arg) ;

    public IBaseLogger info(String format, Object arg1, Object arg2);

    public IBaseLogger info(String format, Object[] argArray) ;
    /*------------------------------------------------------------------------------warn------------------------------*/
    public IBaseLogger warn(String msg);

    public IBaseLogger warn(String msg, Throwable t) ;

    public IBaseLogger warn(String format, Object arg) ;

    public IBaseLogger warn(String format, Object arg1, Object arg2) ;

    public IBaseLogger warn(String format, Object[] argArray);
    /*------------------------------------------------------------------------------error------------------------------*/
    public IBaseLogger error(String msg);

    public IBaseLogger error(String msg, Throwable t) ;

    public IBaseLogger error(String format, Object arg);

    public IBaseLogger error(String format, Object arg1, Object arg2) ;


    public IBaseLogger error(String format, Object[] argArray) ;

    /*------------------------------------------------------------------------------get set------------------------------*/
    public IBaseLogger setValue(String businessName) ;
}

package com.exam.system.manager.entity;

import java.io.Serializable;

/**
 * @packageName：com.exam.system.manager
 * @desrciption: 页面响应结果基类
 * @author: gaowei
 * @date： 2017-11-17 11:26
 * @history: (version) author date desc
 */
public class ResultEntity implements Serializable{

    private static final long serialVersionUID = -108195512296684148L;

    /**
     * 状态 0 ：成功、 1：失败
     */
    private int status;
    /**
     * 描述
     */
    private Message message;
    /**
     * 定向uri
     */
    private String uri;

    /**
     * 返回页面数据
     */
    private ViewData viewData;


    public ViewData getViewData() {
        return viewData;
    }

    public void setViewData(ViewData viewData) {
        this.viewData = viewData;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}

package com.exam.system.manager.entity;

import java.io.Serializable;

/**
 * @packageName：com.exam.system.manager.entity
 * @desrciption: 页面消息实体
 * @author: gaowei
 * @date： 2017-11-17 12:36
 * @history: (version) author date desc
 */
public class Message implements Serializable{

    private static final long serialVersionUID = -3348158900668014845L;

    private String code;
    private String message;

    public Message(String code_i, String message_i) {
        this.code = code_i;
        this.message = message_i;
    }

    @Override
    public String toString() {
        return "Message {" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

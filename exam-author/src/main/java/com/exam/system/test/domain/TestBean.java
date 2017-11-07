package com.exam.system.test.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @packageName：com.exam.system.test.domain
 * @desrciption:
 * @author: gaowei
 * @date： 2017-11-07 14:14
 * @history: (version) author date desc
 */
public class TestBean implements Serializable {

    private static final long serialVersionUID = -137929000994976459L;

    private Integer id;
    private String code;
    private Date create;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

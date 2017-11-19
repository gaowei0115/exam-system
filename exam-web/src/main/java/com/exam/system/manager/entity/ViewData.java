package com.exam.system.manager.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @packageName：com.exam.system.manager.entity
 * @desrciption: 返回页面结果 包含分页信息
 * @author: gaowei
 * @date： 2017/11/18 20:40
 * @history: (version) author date desc
 */
public class ViewData<T> implements Serializable{

    private static final long serialVersionUID = -4344149220660142277L;

    private Integer total;
    private List<T> datas;

    public ViewData(Integer total, List<T> datas) {
        this.total = total;
        this.datas = datas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}

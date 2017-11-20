package com.exam.system.manager.entity;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @packageName：com.exam.system.manager.entity
 * @desrciption: 分页实体对象
 * @author: gaowei
 * @date： 2017/11/18 20:25
 * @history: (version) author date desc
 */
public class PageBean<T> implements Serializable{

    private static final long serialVersionUID = 6063055672654392869L;

    /**
     * 总记录数
     */
    private long total;
    /**
     * 结果集
     */
    private List<T> list;
    /**
     * 第几页
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 当前页的数量<=pageSize
     */
    private int size;

    public PageBean(List<T> list){
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
        }
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

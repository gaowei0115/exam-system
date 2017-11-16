package com.exam.system.manager.course.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desrciption: 考试科目章节实体
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public class ExamCourseChapterEntity implements Serializable{

    private static final long serialVersionUID = -7078811586329592521L;

    private Long id;

    private Long chapterCode;

    private String chapterName;

    private String chapterDesc;

    private Double chapterSp;

    private Long courseId;

    private Date creatTime;

    private Long creator;

    private Date updateTime;

    private Long modifier;

    private String column11;

    private String column12;

    private String column13;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapterCode() {
        return chapterCode;
    }

    public void setChapterCode(Long chapterCode) {
        this.chapterCode = chapterCode;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc == null ? null : chapterDesc.trim();
    }

    public Double getChapterSp() {
        return chapterSp;
    }

    public void setChapterSp(Double chapterSp) {
        this.chapterSp = chapterSp;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getColumn11() {
        return column11;
    }

    public void setColumn11(String column11) {
        this.column11 = column11 == null ? null : column11.trim();
    }

    public String getColumn12() {
        return column12;
    }

    public void setColumn12(String column12) {
        this.column12 = column12 == null ? null : column12.trim();
    }

    public String getColumn13() {
        return column13;
    }

    public void setColumn13(String column13) {
        this.column13 = column13 == null ? null : column13.trim();
    }
}
package com.exam.system.manager.course.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desrciption: 考试专业实体
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public class ExamKindEntity implements Serializable{

    private static final long serialVersionUID = 1958580051740542145L;

    /**
     * 专业编号
     */
    private Long kindId;

    /**
     * 专业名称
     */
    private String kindName;

    /**
     * 专业生效标识（0：生效、1：失效）
     */
    private String kindEffect;

    /**
     * 考试类型编号
     */
    private Long examId;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long modifier;

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    public String getKindEffect() {
        return kindEffect;
    }

    public void setKindEffect(String kindEffect) {
        this.kindEffect = kindEffect == null ? null : kindEffect.trim();
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

}
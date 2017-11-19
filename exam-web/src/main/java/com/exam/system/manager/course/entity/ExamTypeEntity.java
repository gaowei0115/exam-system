package com.exam.system.manager.course.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desrciption: 考试类型实体对象
 * @author: gaowei
 * @date：
 * @history: (version) author date desc
 */
public class ExamTypeEntity implements Serializable{

    private static final long serialVersionUID = 6424183360539021241L;

    /**
     * 考试类型编号
     */
    private Long examId;

    /**
     * 考试类型名称
     */
    private String examName;

    /**
     * 考试类型生效标识（0：生效、1：失效）
     */
    private String examEffect;

    /**
     * 描述
     */
    private String desc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 变更人
     */
    private Long modifier;


    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamEffect() {
        return examEffect;
    }

    public void setExamEffect(String examEffect) {
        this.examEffect = examEffect;
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

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ExamTypeEntity{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", examEffect='" + examEffect + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime=" + createTime +
                ", creator=" + creator +
                ", updateTime=" + updateTime +
                ", modifier=" + modifier +
                '}';
    }
}
package com.course.server.domain;

import java.math.BigDecimal;

public class usualGrade {
    private String id;

    private String courseTargetId;

    private BigDecimal finalExam;

    private BigDecimal usualGrade;

    private BigDecimal classBehave;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseTargetId() {
        return courseTargetId;
    }

    public void setCourseTargetId(String courseTargetId) {
        this.courseTargetId = courseTargetId;
    }

    public BigDecimal getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(BigDecimal finalExam) {
        this.finalExam = finalExam;
    }

    public BigDecimal getUsualGrade() {
        return usualGrade;
    }

    public void setUsualGrade(BigDecimal usualGrade) {
        this.usualGrade = usualGrade;
    }

    public BigDecimal getClassBehave() {
        return classBehave;
    }

    public void setClassBehave(BigDecimal classBehave) {
        this.classBehave = classBehave;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseTargetId=").append(courseTargetId);
        sb.append(", finalExam=").append(finalExam);
        sb.append(", usualGrade=").append(usualGrade);
        sb.append(", classBehave=").append(classBehave);
        sb.append("]");
        return sb.toString();
    }
}
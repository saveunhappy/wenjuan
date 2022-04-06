package com.course.server.domain;

import java.math.BigDecimal;

public class unitTest {
    private String id;

    private String courseTargetId;

    private String courseTargetName;

    private BigDecimal weight;

    private BigDecimal goalGrade;

    private BigDecimal actualAvgGrade;

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

    public String getCourseTargetName() {
        return courseTargetName;
    }

    public void setCourseTargetName(String courseTargetName) {
        this.courseTargetName = courseTargetName;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getGoalGrade() {
        return goalGrade;
    }

    public void setGoalGrade(BigDecimal goalGrade) {
        this.goalGrade = goalGrade;
    }

    public BigDecimal getActualAvgGrade() {
        return actualAvgGrade;
    }

    public void setActualAvgGrade(BigDecimal actualAvgGrade) {
        this.actualAvgGrade = actualAvgGrade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseTargetId=").append(courseTargetId);
        sb.append(", courseTargetName=").append(courseTargetName);
        sb.append(", weight=").append(weight);
        sb.append(", goalGrade=").append(goalGrade);
        sb.append(", actualAvgGrade=").append(actualAvgGrade);
        sb.append("]");
        return sb.toString();
    }
}
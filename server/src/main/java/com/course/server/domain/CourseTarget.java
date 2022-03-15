package com.course.server.domain;

import java.math.BigDecimal;

public class CourseTarget {
    private String id;

    private String target;

    private BigDecimal teacherEvaluate;

    private BigDecimal studentEvaluate;

    private BigDecimal goalScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public BigDecimal getTeacherEvaluate() {
        return teacherEvaluate;
    }

    public void setTeacherEvaluate(BigDecimal teacherEvaluate) {
        this.teacherEvaluate = teacherEvaluate;
    }

    public BigDecimal getStudentEvaluate() {
        return studentEvaluate;
    }

    public void setStudentEvaluate(BigDecimal studentEvaluate) {
        this.studentEvaluate = studentEvaluate;
    }

    public BigDecimal getGoalScore() {
        return goalScore;
    }

    public void setGoalScore(BigDecimal goalScore) {
        this.goalScore = goalScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", target=").append(target);
        sb.append(", teacherEvaluate=").append(teacherEvaluate);
        sb.append(", studentEvaluate=").append(studentEvaluate);
        sb.append(", goalScore=").append(goalScore);
        sb.append("]");
        return sb.toString();
    }
}
package com.course.server.domain;

import java.math.BigDecimal;

public class CourseTargetLow {
    private String id;

    private BigDecimal teacherEvaluate;

    private BigDecimal studentEvaluate;

    private BigDecimal goalGrade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getGoalGrade() {
        return goalGrade;
    }

    public void setGoalGrade(BigDecimal goalGrade) {
        this.goalGrade = goalGrade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teacherEvaluate=").append(teacherEvaluate);
        sb.append(", studentEvaluate=").append(studentEvaluate);
        sb.append(", goalGrade=").append(goalGrade);
        sb.append("]");
        return sb.toString();
    }
}
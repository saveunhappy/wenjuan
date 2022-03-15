package com.course.server.dto;

import java.math.BigDecimal;

public class CourseTargetDto {

    /**
     * id
     */
    private String id;

    /**
     * 课程目标
     */
    private String target;

    /**
     * 老师评价
     */
    private BigDecimal teacherEvaluate;

    /**
     * 学生评价
     */
    private BigDecimal studentEvaluate;

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
        sb.append("]");
        return sb.toString();
    }

}
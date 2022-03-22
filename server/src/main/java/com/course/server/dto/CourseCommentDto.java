package com.course.server.dto;


import com.alibaba.excel.annotation.ExcelProperty;

public class CourseCommentDto {

    /**
     * id
     */
    private String id;

    /**
     * 课程目标id
     */

    private String courseTargetId;

    /**
     * 状态|枚举[CourseCommentStatusEnum]: A("A", "A"),B("B", "B"),C("C", "C"),D("D", "D"),E("E", "E")
     */
    @ExcelProperty(index = 0)
    private String courseComment;

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

    public String getCourseComment() {
        return courseComment;
    }

    public void setCourseComment(String courseComment) {
        this.courseComment = courseComment;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseTargetId=").append(courseTargetId);
        sb.append(", courseComment=").append(courseComment);
        sb.append("]");
        return sb.toString();
    }

}
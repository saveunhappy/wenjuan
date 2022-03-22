package com.course.server.domain;

public class CourseComment {
    private String id;

    private String courseTargetId;

    private String courseTargetName;

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

    public String getCourseTargetName() {
        return courseTargetName;
    }

    public void setCourseTargetName(String courseTargetName) {
        this.courseTargetName = courseTargetName;
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
        sb.append(", courseTargetName=").append(courseTargetName);
        sb.append(", courseComment=").append(courseComment);
        sb.append("]");
        return sb.toString();
    }
}
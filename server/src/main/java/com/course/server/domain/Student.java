package com.course.server.domain;

import java.math.BigDecimal;

public class Student {

    private String className;

    private String studentNumber;

    private String name;

    private String gender;

    private Integer schoolSystem;

    private BigDecimal finalExam;

    private BigDecimal usualGrade;

    private BigDecimal unitTest;

    private BigDecimal classBehave;

    private BigDecimal finalResult;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSchoolSystem() {
        return schoolSystem;
    }

    public void setSchoolSystem(Integer schoolSystem) {
        this.schoolSystem = schoolSystem;
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

    public BigDecimal getUnitTest() {
        return unitTest;
    }

    public void setUnitTest(BigDecimal unitTest) {
        this.unitTest = unitTest;
    }

    public BigDecimal getClassBehave() {
        return classBehave;
    }

    public void setClassBehave(BigDecimal classBehave) {
        this.classBehave = classBehave;
    }

    public BigDecimal getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(BigDecimal finalResult) {
        this.finalResult = finalResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", className=").append(className);
        sb.append(", studentNumber=").append(studentNumber);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", schoolSystem=").append(schoolSystem);
        sb.append(", finalExam=").append(finalExam);
        sb.append(", usualGrade=").append(usualGrade);
        sb.append(", unitTest=").append(unitTest);
        sb.append(", classBehave=").append(classBehave);
        sb.append(", finalResult=").append(finalResult);
        sb.append("]");
        return sb.toString();
    }
}
package com.course.server.domain;

import java.math.BigDecimal;

public class Student {
    private String id;

    private String className;

    private String studentNumber;

    private String name;

    private String gender;

    private Integer schoolSystem;

    private BigDecimal finalExam;

    private BigDecimal usualGrade;

    private BigDecimal unitTest;

    private BigDecimal classBehave;

    private BigDecimal finalExamAvg;

    private BigDecimal usualGradeAvg;

    private BigDecimal unitTestAvg;

    private BigDecimal classBehaveAvg;

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

    public BigDecimal getFinalExamAvg() {
        return finalExamAvg;
    }

    public void setFinalExamAvg(BigDecimal finalExamAvg) {
        this.finalExamAvg = finalExamAvg;
    }

    public BigDecimal getUsualGradeAvg() {
        return usualGradeAvg;
    }

    public void setUsualGradeAvg(BigDecimal usualGradeAvg) {
        this.usualGradeAvg = usualGradeAvg;
    }

    public BigDecimal getUnitTestAvg() {
        return unitTestAvg;
    }

    public void setUnitTestAvg(BigDecimal unitTestAvg) {
        this.unitTestAvg = unitTestAvg;
    }

    public BigDecimal getClassBehaveAvg() {
        return classBehaveAvg;
    }

    public void setClassBehaveAvg(BigDecimal classBehaveAvg) {
        this.classBehaveAvg = classBehaveAvg;
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
        sb.append(", finalExamAvg=").append(finalExamAvg);
        sb.append(", usualGradeAvg=").append(usualGradeAvg);
        sb.append(", unitTestAvg=").append(unitTestAvg);
        sb.append(", classBehaveAvg=").append(classBehaveAvg);
        sb.append("]");
        return sb.toString();
    }
}
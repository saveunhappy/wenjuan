package com.course.server.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.course.server.converter.GenderTypeConverter;

import java.math.BigDecimal;

public class StudentExcellDto {

    /**
     * id
     */
    @ExcelProperty
    @ExcelIgnore
    private String id;

    /**
     * 班级
     */
    @ExcelProperty(value = "班级")
    private String className;

    /**
     * 学号
     */
    @ExcelProperty(value = "学号")
    private String studentNumber;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String name;

    /**
     * 状态|枚举[GenderStatusEnum]:MALE("1", "男性"),FEMALE("0", "女性")
     */
    @ExcelProperty(value = "性别")
    private String gender;

    /**
     * 学制
     */
    @ExcelProperty(value = "学制")
    private Integer schoolSystem;

    /**
     * 结课考试
     */
    @ExcelProperty(value = "结课考试")
    private BigDecimal finalExam;

    /**
     * 平时成绩
     */
    @ExcelProperty(value = "平时成绩")
    private BigDecimal usualGrade;

    /**
     * 单元测试
     */
    @ExcelProperty(value = "单元测试")
    private BigDecimal unitTest;

    /**
     * 课堂表现与考勤
     */
    @ExcelProperty(value = "课堂表现与考勤")
    private BigDecimal classBehave;

    /**
     * 综合成绩
     */
    @ExcelProperty(value = "综合成绩")
    private BigDecimal finalResult;

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
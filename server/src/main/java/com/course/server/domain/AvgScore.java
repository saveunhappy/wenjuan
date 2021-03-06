package com.course.server.domain;

import java.math.BigDecimal;

public class AvgScore {
    private String id;

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
        sb.append(", finalExamAvg=").append(finalExamAvg);
        sb.append(", usualGradeAvg=").append(usualGradeAvg);
        sb.append(", unitTestAvg=").append(unitTestAvg);
        sb.append(", classBehaveAvg=").append(classBehaveAvg);
        sb.append("]");
        return sb.toString();
    }
}
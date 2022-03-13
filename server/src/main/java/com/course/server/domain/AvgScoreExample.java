package com.course.server.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AvgScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AvgScoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgIsNull() {
            addCriterion("final_exam_avg is null");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgIsNotNull() {
            addCriterion("final_exam_avg is not null");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgEqualTo(BigDecimal value) {
            addCriterion("final_exam_avg =", value, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgNotEqualTo(BigDecimal value) {
            addCriterion("final_exam_avg <>", value, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgGreaterThan(BigDecimal value) {
            addCriterion("final_exam_avg >", value, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_exam_avg >=", value, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgLessThan(BigDecimal value) {
            addCriterion("final_exam_avg <", value, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_exam_avg <=", value, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgIn(List<BigDecimal> values) {
            addCriterion("final_exam_avg in", values, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgNotIn(List<BigDecimal> values) {
            addCriterion("final_exam_avg not in", values, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_exam_avg between", value1, value2, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andFinalExamAvgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_exam_avg not between", value1, value2, "finalExamAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgIsNull() {
            addCriterion("usual_grade_avg is null");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgIsNotNull() {
            addCriterion("usual_grade_avg is not null");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgEqualTo(BigDecimal value) {
            addCriterion("usual_grade_avg =", value, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgNotEqualTo(BigDecimal value) {
            addCriterion("usual_grade_avg <>", value, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgGreaterThan(BigDecimal value) {
            addCriterion("usual_grade_avg >", value, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("usual_grade_avg >=", value, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgLessThan(BigDecimal value) {
            addCriterion("usual_grade_avg <", value, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("usual_grade_avg <=", value, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgIn(List<BigDecimal> values) {
            addCriterion("usual_grade_avg in", values, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgNotIn(List<BigDecimal> values) {
            addCriterion("usual_grade_avg not in", values, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usual_grade_avg between", value1, value2, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUsualGradeAvgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usual_grade_avg not between", value1, value2, "usualGradeAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgIsNull() {
            addCriterion("unit_test_avg is null");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgIsNotNull() {
            addCriterion("unit_test_avg is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgEqualTo(BigDecimal value) {
            addCriterion("unit_test_avg =", value, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgNotEqualTo(BigDecimal value) {
            addCriterion("unit_test_avg <>", value, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgGreaterThan(BigDecimal value) {
            addCriterion("unit_test_avg >", value, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_test_avg >=", value, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgLessThan(BigDecimal value) {
            addCriterion("unit_test_avg <", value, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_test_avg <=", value, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgIn(List<BigDecimal> values) {
            addCriterion("unit_test_avg in", values, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgNotIn(List<BigDecimal> values) {
            addCriterion("unit_test_avg not in", values, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_test_avg between", value1, value2, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andUnitTestAvgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_test_avg not between", value1, value2, "unitTestAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgIsNull() {
            addCriterion("final_result_avg is null");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgIsNotNull() {
            addCriterion("final_result_avg is not null");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgEqualTo(BigDecimal value) {
            addCriterion("final_result_avg =", value, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgNotEqualTo(BigDecimal value) {
            addCriterion("final_result_avg <>", value, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgGreaterThan(BigDecimal value) {
            addCriterion("final_result_avg >", value, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_result_avg >=", value, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgLessThan(BigDecimal value) {
            addCriterion("final_result_avg <", value, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_result_avg <=", value, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgIn(List<BigDecimal> values) {
            addCriterion("final_result_avg in", values, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgNotIn(List<BigDecimal> values) {
            addCriterion("final_result_avg not in", values, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_result_avg between", value1, value2, "finalResultAvg");
            return (Criteria) this;
        }

        public Criteria andFinalResultAvgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_result_avg not between", value1, value2, "finalResultAvg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
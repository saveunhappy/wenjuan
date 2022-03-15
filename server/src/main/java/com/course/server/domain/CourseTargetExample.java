package com.course.server.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CourseTargetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseTargetExample() {
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

        public Criteria andTargetIsNull() {
            addCriterion("target is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("target is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(String value) {
            addCriterion("target =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(String value) {
            addCriterion("target <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(String value) {
            addCriterion("target >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(String value) {
            addCriterion("target >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(String value) {
            addCriterion("target <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(String value) {
            addCriterion("target <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLike(String value) {
            addCriterion("target like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotLike(String value) {
            addCriterion("target not like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<String> values) {
            addCriterion("target in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<String> values) {
            addCriterion("target not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(String value1, String value2) {
            addCriterion("target between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(String value1, String value2) {
            addCriterion("target not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateIsNull() {
            addCriterion("teacher_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateIsNotNull() {
            addCriterion("teacher_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateEqualTo(BigDecimal value) {
            addCriterion("teacher_evaluate =", value, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("teacher_evaluate <>", value, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateGreaterThan(BigDecimal value) {
            addCriterion("teacher_evaluate >", value, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_evaluate >=", value, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateLessThan(BigDecimal value) {
            addCriterion("teacher_evaluate <", value, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_evaluate <=", value, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateIn(List<BigDecimal> values) {
            addCriterion("teacher_evaluate in", values, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("teacher_evaluate not in", values, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_evaluate between", value1, value2, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andTeacherEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_evaluate not between", value1, value2, "teacherEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateIsNull() {
            addCriterion("student_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateIsNotNull() {
            addCriterion("student_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateEqualTo(BigDecimal value) {
            addCriterion("student_evaluate =", value, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("student_evaluate <>", value, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateGreaterThan(BigDecimal value) {
            addCriterion("student_evaluate >", value, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("student_evaluate >=", value, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateLessThan(BigDecimal value) {
            addCriterion("student_evaluate <", value, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("student_evaluate <=", value, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateIn(List<BigDecimal> values) {
            addCriterion("student_evaluate in", values, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("student_evaluate not in", values, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("student_evaluate between", value1, value2, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andStudentEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("student_evaluate not between", value1, value2, "studentEvaluate");
            return (Criteria) this;
        }

        public Criteria andGoalScoreIsNull() {
            addCriterion("goal_score is null");
            return (Criteria) this;
        }

        public Criteria andGoalScoreIsNotNull() {
            addCriterion("goal_score is not null");
            return (Criteria) this;
        }

        public Criteria andGoalScoreEqualTo(BigDecimal value) {
            addCriterion("goal_score =", value, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreNotEqualTo(BigDecimal value) {
            addCriterion("goal_score <>", value, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreGreaterThan(BigDecimal value) {
            addCriterion("goal_score >", value, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goal_score >=", value, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreLessThan(BigDecimal value) {
            addCriterion("goal_score <", value, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goal_score <=", value, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreIn(List<BigDecimal> values) {
            addCriterion("goal_score in", values, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreNotIn(List<BigDecimal> values) {
            addCriterion("goal_score not in", values, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goal_score between", value1, value2, "goalScore");
            return (Criteria) this;
        }

        public Criteria andGoalScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goal_score not between", value1, value2, "goalScore");
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
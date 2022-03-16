package com.course.server.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class usualGradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public usualGradeExample() {
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

        public Criteria andCourseTargetIdIsNull() {
            addCriterion("course_target_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdIsNotNull() {
            addCriterion("course_target_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdEqualTo(String value) {
            addCriterion("course_target_id =", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdNotEqualTo(String value) {
            addCriterion("course_target_id <>", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdGreaterThan(String value) {
            addCriterion("course_target_id >", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_target_id >=", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdLessThan(String value) {
            addCriterion("course_target_id <", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdLessThanOrEqualTo(String value) {
            addCriterion("course_target_id <=", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdLike(String value) {
            addCriterion("course_target_id like", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdNotLike(String value) {
            addCriterion("course_target_id not like", value, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdIn(List<String> values) {
            addCriterion("course_target_id in", values, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdNotIn(List<String> values) {
            addCriterion("course_target_id not in", values, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdBetween(String value1, String value2) {
            addCriterion("course_target_id between", value1, value2, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andCourseTargetIdNotBetween(String value1, String value2) {
            addCriterion("course_target_id not between", value1, value2, "courseTargetId");
            return (Criteria) this;
        }

        public Criteria andFinalExamIsNull() {
            addCriterion("final_exam is null");
            return (Criteria) this;
        }

        public Criteria andFinalExamIsNotNull() {
            addCriterion("final_exam is not null");
            return (Criteria) this;
        }

        public Criteria andFinalExamEqualTo(BigDecimal value) {
            addCriterion("final_exam =", value, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamNotEqualTo(BigDecimal value) {
            addCriterion("final_exam <>", value, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamGreaterThan(BigDecimal value) {
            addCriterion("final_exam >", value, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_exam >=", value, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamLessThan(BigDecimal value) {
            addCriterion("final_exam <", value, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_exam <=", value, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamIn(List<BigDecimal> values) {
            addCriterion("final_exam in", values, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamNotIn(List<BigDecimal> values) {
            addCriterion("final_exam not in", values, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_exam between", value1, value2, "finalExam");
            return (Criteria) this;
        }

        public Criteria andFinalExamNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_exam not between", value1, value2, "finalExam");
            return (Criteria) this;
        }

        public Criteria andUsualGradeIsNull() {
            addCriterion("usual_grade is null");
            return (Criteria) this;
        }

        public Criteria andUsualGradeIsNotNull() {
            addCriterion("usual_grade is not null");
            return (Criteria) this;
        }

        public Criteria andUsualGradeEqualTo(BigDecimal value) {
            addCriterion("usual_grade =", value, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeNotEqualTo(BigDecimal value) {
            addCriterion("usual_grade <>", value, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeGreaterThan(BigDecimal value) {
            addCriterion("usual_grade >", value, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("usual_grade >=", value, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeLessThan(BigDecimal value) {
            addCriterion("usual_grade <", value, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("usual_grade <=", value, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeIn(List<BigDecimal> values) {
            addCriterion("usual_grade in", values, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeNotIn(List<BigDecimal> values) {
            addCriterion("usual_grade not in", values, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usual_grade between", value1, value2, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andUsualGradeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usual_grade not between", value1, value2, "usualGrade");
            return (Criteria) this;
        }

        public Criteria andClassBehaveIsNull() {
            addCriterion("class_behave is null");
            return (Criteria) this;
        }

        public Criteria andClassBehaveIsNotNull() {
            addCriterion("class_behave is not null");
            return (Criteria) this;
        }

        public Criteria andClassBehaveEqualTo(BigDecimal value) {
            addCriterion("class_behave =", value, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveNotEqualTo(BigDecimal value) {
            addCriterion("class_behave <>", value, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveGreaterThan(BigDecimal value) {
            addCriterion("class_behave >", value, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("class_behave >=", value, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveLessThan(BigDecimal value) {
            addCriterion("class_behave <", value, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("class_behave <=", value, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveIn(List<BigDecimal> values) {
            addCriterion("class_behave in", values, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveNotIn(List<BigDecimal> values) {
            addCriterion("class_behave not in", values, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("class_behave between", value1, value2, "classBehave");
            return (Criteria) this;
        }

        public Criteria andClassBehaveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("class_behave not between", value1, value2, "classBehave");
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
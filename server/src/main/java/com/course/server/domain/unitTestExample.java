package com.course.server.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class unitTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public unitTestExample() {
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

        public Criteria andCourseTargetNameIsNull() {
            addCriterion("course_target_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameIsNotNull() {
            addCriterion("course_target_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameEqualTo(String value) {
            addCriterion("course_target_name =", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameNotEqualTo(String value) {
            addCriterion("course_target_name <>", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameGreaterThan(String value) {
            addCriterion("course_target_name >", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_target_name >=", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameLessThan(String value) {
            addCriterion("course_target_name <", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameLessThanOrEqualTo(String value) {
            addCriterion("course_target_name <=", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameLike(String value) {
            addCriterion("course_target_name like", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameNotLike(String value) {
            addCriterion("course_target_name not like", value, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameIn(List<String> values) {
            addCriterion("course_target_name in", values, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameNotIn(List<String> values) {
            addCriterion("course_target_name not in", values, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameBetween(String value1, String value2) {
            addCriterion("course_target_name between", value1, value2, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andCourseTargetNameNotBetween(String value1, String value2) {
            addCriterion("course_target_name not between", value1, value2, "courseTargetName");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andGoalGradeIsNull() {
            addCriterion("goal_grade is null");
            return (Criteria) this;
        }

        public Criteria andGoalGradeIsNotNull() {
            addCriterion("goal_grade is not null");
            return (Criteria) this;
        }

        public Criteria andGoalGradeEqualTo(BigDecimal value) {
            addCriterion("goal_grade =", value, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeNotEqualTo(BigDecimal value) {
            addCriterion("goal_grade <>", value, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeGreaterThan(BigDecimal value) {
            addCriterion("goal_grade >", value, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goal_grade >=", value, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeLessThan(BigDecimal value) {
            addCriterion("goal_grade <", value, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goal_grade <=", value, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeIn(List<BigDecimal> values) {
            addCriterion("goal_grade in", values, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeNotIn(List<BigDecimal> values) {
            addCriterion("goal_grade not in", values, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goal_grade between", value1, value2, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andGoalGradeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goal_grade not between", value1, value2, "goalGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeIsNull() {
            addCriterion("actual_avg_grade is null");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeIsNotNull() {
            addCriterion("actual_avg_grade is not null");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeEqualTo(BigDecimal value) {
            addCriterion("actual_avg_grade =", value, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeNotEqualTo(BigDecimal value) {
            addCriterion("actual_avg_grade <>", value, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeGreaterThan(BigDecimal value) {
            addCriterion("actual_avg_grade >", value, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_avg_grade >=", value, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeLessThan(BigDecimal value) {
            addCriterion("actual_avg_grade <", value, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_avg_grade <=", value, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeIn(List<BigDecimal> values) {
            addCriterion("actual_avg_grade in", values, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeNotIn(List<BigDecimal> values) {
            addCriterion("actual_avg_grade not in", values, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_avg_grade between", value1, value2, "actualAvgGrade");
            return (Criteria) this;
        }

        public Criteria andActualAvgGradeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_avg_grade not between", value1, value2, "actualAvgGrade");
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
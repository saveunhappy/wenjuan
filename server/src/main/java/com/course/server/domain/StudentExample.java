package com.course.server.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIsNull() {
            addCriterion("student_number is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIsNotNull() {
            addCriterion("student_number is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberEqualTo(String value) {
            addCriterion("student_number =", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotEqualTo(String value) {
            addCriterion("student_number <>", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThan(String value) {
            addCriterion("student_number >", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("student_number >=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThan(String value) {
            addCriterion("student_number <", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThanOrEqualTo(String value) {
            addCriterion("student_number <=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLike(String value) {
            addCriterion("student_number like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotLike(String value) {
            addCriterion("student_number not like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIn(List<String> values) {
            addCriterion("student_number in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotIn(List<String> values) {
            addCriterion("student_number not in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberBetween(String value1, String value2) {
            addCriterion("student_number between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotBetween(String value1, String value2) {
            addCriterion("student_number not between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemIsNull() {
            addCriterion("school_system is null");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemIsNotNull() {
            addCriterion("school_system is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemEqualTo(Integer value) {
            addCriterion("school_system =", value, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemNotEqualTo(Integer value) {
            addCriterion("school_system <>", value, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemGreaterThan(Integer value) {
            addCriterion("school_system >", value, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_system >=", value, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemLessThan(Integer value) {
            addCriterion("school_system <", value, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemLessThanOrEqualTo(Integer value) {
            addCriterion("school_system <=", value, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemIn(List<Integer> values) {
            addCriterion("school_system in", values, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemNotIn(List<Integer> values) {
            addCriterion("school_system not in", values, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemBetween(Integer value1, Integer value2) {
            addCriterion("school_system between", value1, value2, "schoolSystem");
            return (Criteria) this;
        }

        public Criteria andSchoolSystemNotBetween(Integer value1, Integer value2) {
            addCriterion("school_system not between", value1, value2, "schoolSystem");
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

        public Criteria andUnitTestIsNull() {
            addCriterion("unit_test is null");
            return (Criteria) this;
        }

        public Criteria andUnitTestIsNotNull() {
            addCriterion("unit_test is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTestEqualTo(BigDecimal value) {
            addCriterion("unit_test =", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestNotEqualTo(BigDecimal value) {
            addCriterion("unit_test <>", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestGreaterThan(BigDecimal value) {
            addCriterion("unit_test >", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_test >=", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestLessThan(BigDecimal value) {
            addCriterion("unit_test <", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_test <=", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestIn(List<BigDecimal> values) {
            addCriterion("unit_test in", values, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestNotIn(List<BigDecimal> values) {
            addCriterion("unit_test not in", values, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_test between", value1, value2, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_test not between", value1, value2, "unitTest");
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

        public Criteria andClassBehaveAvgIsNull() {
            addCriterion("class_behave_avg is null");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgIsNotNull() {
            addCriterion("class_behave_avg is not null");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgEqualTo(BigDecimal value) {
            addCriterion("class_behave_avg =", value, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgNotEqualTo(BigDecimal value) {
            addCriterion("class_behave_avg <>", value, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgGreaterThan(BigDecimal value) {
            addCriterion("class_behave_avg >", value, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("class_behave_avg >=", value, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgLessThan(BigDecimal value) {
            addCriterion("class_behave_avg <", value, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("class_behave_avg <=", value, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgIn(List<BigDecimal> values) {
            addCriterion("class_behave_avg in", values, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgNotIn(List<BigDecimal> values) {
            addCriterion("class_behave_avg not in", values, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("class_behave_avg between", value1, value2, "classBehaveAvg");
            return (Criteria) this;
        }

        public Criteria andClassBehaveAvgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("class_behave_avg not between", value1, value2, "classBehaveAvg");
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
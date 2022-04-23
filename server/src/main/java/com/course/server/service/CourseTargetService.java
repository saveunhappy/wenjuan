package com.course.server.service;

import com.course.server.domain.CourseTarget;
import com.course.server.domain.CourseTargetExample;
import com.course.server.domain.CourseTargetLow;
import com.course.server.dto.*;
import com.course.server.mapper.CourseTargetLowMapper;
import com.course.server.mapper.CourseTargetMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CourseTargetService {
    public static final String COURSE_ID = "00000000";
    @Resource
    private CourseTargetMapper courseTargetMapper;
    @Resource
    private CourseTargetLowService courseTargetLowService;
    @Resource
    private CourseTargetLowMapper courseTargetLowMapper;
    @Resource
    private finalExamService finalExamService;
    @Resource
    private classBehaveService classBehaveService;
    @Resource
    private usualGradeService usualGradeService;
    @Resource
    private unitTestService unitTestService;
    @Resource
    private AvgScoreService avgScoreService;
    @Resource
    private CourseTargetService courseTargetService;

    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        CourseTargetExample courseTargetExample = new CourseTargetExample();
        List<CourseTarget> courseTargetList = courseTargetMapper.selectByExample(courseTargetExample);
        List<AvgScoreDto> avgScoreDtos = avgScoreService.getAvg();
        AvgScoreDto avgScoreDto = avgScoreDtos.get(0);
        BigDecimal hundred = new BigDecimal("100");
        for (CourseTarget courseTarget : courseTargetList) {
            String id = courseTarget.getId();
            finalExamDto finalExamDto = finalExamService.getOne(id);
            classBehaveDto classBehaveDto = classBehaveService.getOne(id);
            usualGradeDto usualGradeDto = usualGradeService.getOne(id);
            unitTestDto unitTestDto = unitTestService.getOne(id);
            if(finalExamDto!= null&& classBehaveDto!=null&&usualGradeDto!=null&&unitTestDto!=null){
                String courseTargetId = finalExamDto.getCourseTargetId();
                CourseTarget courseTargetGoalEvaluate = courseTargetMapper.selectByPrimaryKey(courseTargetId);

                BigDecimal finalExamGrade = finalExamDto.getGoalGrade();
                BigDecimal classBehaveGoalGrade = classBehaveDto.getGoalGrade();
                BigDecimal usualGradeGoalGrade = usualGradeDto.getGoalGrade();
                BigDecimal unitTestDtoGoalGrade = unitTestDto.getGoalGrade();
                finalExamDto.setWeight(getWeight(finalExamGrade,classBehaveGoalGrade,usualGradeGoalGrade,unitTestDtoGoalGrade));
                classBehaveDto.setWeight(getWeight(classBehaveGoalGrade,finalExamGrade,usualGradeGoalGrade,unitTestDtoGoalGrade));
                usualGradeDto.setWeight(getWeight(usualGradeGoalGrade,finalExamGrade,classBehaveGoalGrade,unitTestDtoGoalGrade));
                unitTestDto.setWeight(getWeight(unitTestDtoGoalGrade,usualGradeGoalGrade,finalExamGrade,classBehaveGoalGrade));

                finalExamDto.setActualAvgGrade(finalExamGrade.multiply(avgScoreDto.getFinalExamAvg()).divide(hundred,2));
                classBehaveDto.setActualAvgGrade(classBehaveGoalGrade.multiply(avgScoreDto.getClassBehaveAvg()).divide(hundred,2));
                usualGradeDto.setActualAvgGrade(usualGradeGoalGrade.multiply(avgScoreDto.getUsualGradeAvg()).divide(hundred,2));
                unitTestDto.setActualAvgGrade(unitTestDtoGoalGrade.multiply(avgScoreDto.getUnitTestAvg()).divide(hundred,2));
                finalExamService.save(finalExamDto);
                classBehaveService.save(classBehaveDto);
                usualGradeService.save(usualGradeDto);
                unitTestService.save(unitTestDto);
                BigDecimal finalExamGoalEvaluate = finalExamDto.getActualAvgGrade().divide(finalExamDto.getGoalGrade(), 2).multiply(finalExamDto.getWeight());
                BigDecimal classBehaveGoalEvaluate = classBehaveDto.getActualAvgGrade().divide(classBehaveDto.getGoalGrade(), 2).multiply(classBehaveDto.getWeight());
                BigDecimal usualGradeGoalEvaluate = usualGradeDto.getActualAvgGrade().divide(usualGradeDto.getGoalGrade(), 2).multiply(usualGradeDto.getWeight());
                BigDecimal unitTestGoalEvaluate = unitTestDto.getActualAvgGrade().divide(unitTestDto.getGoalGrade(),2).multiply(unitTestDto.getWeight());
                courseTargetGoalEvaluate.setGoalScore(finalExamGoalEvaluate.add(classBehaveGoalEvaluate).add(usualGradeGoalEvaluate).add(unitTestGoalEvaluate));
                CourseTargetDto targetDto = CopyUtil.copy(courseTargetGoalEvaluate, CourseTargetDto.class);
                courseTargetService.save(targetDto);
            }

        }
        courseTargetLowMapper.deleteByPrimaryKey(COURSE_ID);
        CourseTargetLowDto courseTargetLow = new CourseTargetLowDto();
        List<BigDecimal> teacherList = courseTargetList.stream().map(CourseTarget::getTeacherEvaluate).collect(Collectors.toList());
        BigDecimal teacherLow = teacherList.get(0);

        for (BigDecimal teacher : teacherList) {
            if(teacher != null){
                if(teacherLow.compareTo(teacher) >= 0){
                    teacherLow = teacher;
                }
            }

        }

        List<BigDecimal> goalScoresList = courseTargetList.stream().map(CourseTarget::getGoalScore).collect(Collectors.toList());

        BigDecimal goalLow = goalScoresList.get(0);

        for (BigDecimal goalScore : goalScoresList) {
            if(goalScore!= null){
                if(goalLow.compareTo(goalScore) >= 0){
                    goalLow = goalScore;
                }
            }

        }

        List<BigDecimal> studentList = courseTargetList.stream().map(CourseTarget::getStudentEvaluate).collect(Collectors.toList());
        BigDecimal studentLow = studentList.get(0);

        for (BigDecimal student : studentList) {
            if(student!= null){
                if(studentLow.compareTo(student) >= 0){
                    studentLow = student;
                }
            }

        }


        courseTargetLow.setId(COURSE_ID);
        courseTargetLow.setTeacherEvaluate(teacherLow);
        courseTargetLow.setGoalGrade(goalLow);
        courseTargetLow.setStudentEvaluate(studentLow);
        courseTargetLowService.save(courseTargetLow);


        PageInfo pageInfo = new PageInfo(courseTargetList);
        pageDto.setTotal(pageInfo.getTotal());

        List<CourseTargetDto> courseTargetDtoList = CopyUtil.copyList(courseTargetList, CourseTargetDto.class);
        pageDto.setList(courseTargetDtoList);
    }

    public CourseTargetDto getOne(String courseTargetId){

        CourseTargetExample courseTargetExample = new CourseTargetExample();
        CourseTargetExample.Criteria criteria = courseTargetExample.createCriteria();
        if(courseTargetId != null){
            criteria.andIdEqualTo(courseTargetId);
        }
        List<CourseTarget> courseTargetList = courseTargetMapper.selectByExample(courseTargetExample);
        List<CourseTargetDto> courseTargetDtos = CopyUtil.copyList(courseTargetList, CourseTargetDto.class);
        return courseTargetDtos.get(0);
    }

    public BigDecimal getWeight(BigDecimal finalExamGrade,BigDecimal classBehaveGoalGrade,BigDecimal usualGradeGoalGrade,BigDecimal unitTestGoalGrade){
        if(finalExamGrade == null || classBehaveGoalGrade == null || usualGradeGoalGrade == null || unitTestGoalGrade == null){
            return BigDecimal.ZERO;
        }
        BigDecimal sum = finalExamGrade.add(classBehaveGoalGrade).add(usualGradeGoalGrade).add(unitTestGoalGrade);
        return finalExamGrade.divide(sum,3);
    }
    public void save(CourseTargetDto courseTargetDto){
        CourseTarget courseTarget = CopyUtil.copy(courseTargetDto, CourseTarget.class);

        if(StringUtils.isEmpty(courseTargetDto.getId())){
            this.insert(courseTarget);
        }else{
            this.update(courseTarget);
        }
    }

    private void insert(CourseTarget courseTarget){
        courseTarget.setId(UuidUtil.getShortUuid());
        courseTargetMapper.insert(courseTarget);
    }
    private void update(CourseTarget courseTarget){
        courseTargetMapper.updateByPrimaryKey(courseTarget);
    }

    public void delete(String id) {
        courseTargetMapper.deleteByPrimaryKey(id);
    }
}

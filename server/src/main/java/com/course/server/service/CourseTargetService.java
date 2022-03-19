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
            if(finalExamDto!= null&& classBehaveDto!=null&&usualGradeDto!=null){
                String courseTargetId = finalExamDto.getCourseTargetId();
                CourseTarget courseTargetGoalEvaluate = courseTargetMapper.selectByPrimaryKey(courseTargetId);




                BigDecimal finalExamGrade = finalExamDto.getGoalGrade();
                BigDecimal classBehaveGoalGrade = classBehaveDto.getGoalGrade();
                BigDecimal usualGradeGoalGrade = usualGradeDto.getGoalGrade();

                finalExamDto.setWeight(getWeight(finalExamGrade,classBehaveGoalGrade,usualGradeGoalGrade));
                classBehaveDto.setWeight(getWeight(classBehaveGoalGrade,finalExamGrade,usualGradeGoalGrade));
                usualGradeDto.setWeight(getWeight(usualGradeGoalGrade,finalExamGrade,classBehaveGoalGrade));


                finalExamDto.setActualAvgGrade(finalExamGrade.multiply(avgScoreDto.getFinalExamAvg().divide(hundred,2)));
                classBehaveDto.setActualAvgGrade(classBehaveGoalGrade.multiply(avgScoreDto.getClassBehaveAvg().divide(hundred,2)));
                usualGradeDto.setActualAvgGrade(usualGradeGoalGrade.multiply(avgScoreDto.getUsualGradeAvg()).divide(hundred,2));
                finalExamService.save(finalExamDto);
                classBehaveService.save(classBehaveDto);
                usualGradeService.save(usualGradeDto);
                BigDecimal finalExamGoalEvaluate = finalExamDto.getActualAvgGrade().divide(finalExamDto.getGoalGrade(), 2).multiply(finalExamDto.getWeight());
                BigDecimal classBehaveGoalEvaluate = classBehaveDto.getActualAvgGrade().divide(classBehaveDto.getGoalGrade(), 2).multiply(classBehaveDto.getWeight());
                BigDecimal usualGradeGoalEvaluate = usualGradeDto.getActualAvgGrade().divide(usualGradeDto.getGoalGrade(), 2).multiply(classBehaveDto.getWeight());

                courseTargetGoalEvaluate.setGoalScore(finalExamGoalEvaluate.add(classBehaveGoalEvaluate).add(usualGradeGoalEvaluate));
                CourseTargetDto targetDto = CopyUtil.copy(courseTargetGoalEvaluate, CourseTargetDto.class);
                courseTargetService.save(targetDto);
            }

        }
        courseTargetLowMapper.deleteByPrimaryKey(COURSE_ID);
        CourseTargetLowDto courseTargetLow = new CourseTargetLowDto();
        List<BigDecimal> teacherList = courseTargetList.stream().map(CourseTarget::getTeacherEvaluate).collect(Collectors.toList());
        BigDecimal teacherLow = teacherList.get(0);

        for (BigDecimal teacher : teacherList) {
            if(teacherLow.compareTo(teacher) >= 0){
                teacherLow = teacher;
            }
        }

        courseTargetLow.setId(COURSE_ID);
        courseTargetLow.setTeacherEvaluate(teacherLow);
        courseTargetLowService.save(courseTargetLow);


        PageInfo pageInfo = new PageInfo(courseTargetList);
        pageDto.setTotal(pageInfo.getTotal());

        List<CourseTargetDto> courseTargetDtoList = CopyUtil.copyList(courseTargetList, CourseTargetDto.class);
        pageDto.setList(courseTargetDtoList);
    }
    public BigDecimal getWeight(BigDecimal finalExamGrade,BigDecimal classBehaveGoalGrade,BigDecimal usualGradeGoalGrade){
        if(finalExamGrade == null || classBehaveGoalGrade == null || usualGradeGoalGrade == null){
            return BigDecimal.ZERO;
        }
        BigDecimal sum = finalExamGrade.add(classBehaveGoalGrade).add(usualGradeGoalGrade);
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

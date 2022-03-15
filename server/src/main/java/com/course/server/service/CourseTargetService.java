package com.course.server.service;

import com.course.server.domain.CourseTarget;
import com.course.server.domain.CourseTargetExample;
import com.course.server.domain.CourseTargetLow;
import com.course.server.dto.CourseTargetDto;
import com.course.server.dto.CourseTargetLowDto;
import com.course.server.dto.PageDto;
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
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        CourseTargetExample courseTargetExample = new CourseTargetExample();
        List<CourseTarget> courseTargetList = courseTargetMapper.selectByExample(courseTargetExample);
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

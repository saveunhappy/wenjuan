package com.course.server.service;

import com.course.server.domain.CourseTargetLow;
import com.course.server.domain.CourseTargetLowExample;
import com.course.server.dto.CourseTargetLowDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.CourseTargetLowMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class CourseTargetLowService {
    @Resource
    private CourseTargetLowMapper courseTargetLowMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        CourseTargetLowExample courseTargetLowExample = new CourseTargetLowExample();
        List<CourseTargetLow> courseTargetLowList = courseTargetLowMapper.selectByExample(courseTargetLowExample);
        PageInfo pageInfo = new PageInfo(courseTargetLowList);
        pageDto.setTotal(pageInfo.getTotal());

        List<CourseTargetLowDto> courseTargetLowDtoList = CopyUtil.copyList(courseTargetLowList, CourseTargetLowDto.class);
        pageDto.setList(courseTargetLowDtoList);
    }

    public void save(CourseTargetLowDto courseTargetLowDto){
        CourseTargetLow courseTargetLow = CopyUtil.copy(courseTargetLowDto, CourseTargetLow.class);

            this.insert(courseTargetLow);
    }

    private void insert(CourseTargetLow courseTargetLow){
        courseTargetLow.setId(courseTargetLow.getId());
        courseTargetLowMapper.insert(courseTargetLow);
    }
    private void update(CourseTargetLow courseTargetLow){
        courseTargetLowMapper.updateByPrimaryKey(courseTargetLow);
    }

    public void delete(String id) {
        courseTargetLowMapper.deleteByPrimaryKey(id);
    }
}

package com.course.server.service;

import com.course.server.domain.CourseTarget;
import com.course.server.domain.CourseTargetExample;
import com.course.server.dto.CourseTargetDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.CourseTargetMapper;
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
public class CourseTargetService {
    @Resource
    private CourseTargetMapper courseTargetMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        CourseTargetExample courseTargetExample = new CourseTargetExample();
        List<CourseTarget> courseTargetList = courseTargetMapper.selectByExample(courseTargetExample);
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

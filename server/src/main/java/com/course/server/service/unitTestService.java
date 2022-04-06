package com.course.server.service;

import com.course.server.domain.*;
import com.course.server.dto.CourseTargetDto;
import com.course.server.dto.classBehaveDto;
import com.course.server.dto.unitTestDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.classBehaveMapper;
import com.course.server.mapper.unitTestMapper;
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
public class unitTestService {
    @Resource
    private unitTestMapper unitTestMapper;
    @Resource
    private CourseTargetService courseTargetService;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        unitTestExample unitTestExample = new unitTestExample();
        List<unitTest> unitTestList = unitTestMapper.selectByExample(unitTestExample);
        PageInfo pageInfo = new PageInfo(unitTestList);
        pageDto.setTotal(pageInfo.getTotal());

        List<unitTestDto> unitTestDtoList = CopyUtil.copyList(unitTestList, unitTestDto.class);
        pageDto.setList(unitTestDtoList);
    }

    public void save(unitTestDto unitTestDto){
        unitTest unitTest = CopyUtil.copy(unitTestDto, unitTest.class);
        CourseTargetDto courseTargetDto =  courseTargetService.getOne(unitTestDto.getCourseTargetId());
        unitTest.setCourseTargetName(courseTargetDto.getTarget());
        if(StringUtils.isEmpty(unitTestDto.getId())){
            this.insert(unitTest);
        }else{
            this.update(unitTest);
        }
    }
    public unitTestDto getOne(String courseTargetId){
        unitTestExample unitTestExample = new unitTestExample();
        com.course.server.domain.unitTestExample.Criteria criteria = unitTestExample.createCriteria();
        if(!StringUtils.isEmpty(courseTargetId)){
            criteria.andCourseTargetIdEqualTo(courseTargetId);
        }
        List<unitTest> unitTestList = unitTestMapper.selectByExample(unitTestExample);
        List<unitTestDto> unitTestDtoList = CopyUtil.copyList(unitTestList, unitTestDto.class);
        if(unitTestDtoList.size()==0){
            return null;
        }
        return unitTestDtoList.get(0);
    }
    private void insert(unitTest unitTest){
        unitTest.setId(UuidUtil.getShortUuid());
        unitTestMapper.insert(unitTest);
    }
    private void update(unitTest unitTest){
        unitTestMapper.updateByPrimaryKey(unitTest);
    }

    public void delete(String id) {
        unitTestMapper.deleteByPrimaryKey(id);
    }
}

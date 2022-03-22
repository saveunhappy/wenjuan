package com.course.server.service;

import com.course.server.domain.finalExam;
import com.course.server.domain.finalExamExample;
import com.course.server.dto.CourseTargetDto;
import com.course.server.dto.finalExamDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.finalExamMapper;
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
public class finalExamService {
    @Resource
    private finalExamMapper finalExamMapper;
    @Resource
    private CourseTargetService courseTargetService;
    public void list(finalExamDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        finalExamExample finalExamExample = new finalExamExample();

        List<finalExam> finalExamList = finalExamMapper.selectByExample(finalExamExample);
        PageInfo pageInfo = new PageInfo(finalExamList);
        pageDto.setTotal(pageInfo.getTotal());

        List<finalExamDto> finalExamDtoList = CopyUtil.copyList(finalExamList, finalExamDto.class);
        pageDto.setList(finalExamDtoList);
    }

    public finalExamDto getOne(String courseTargetId){
        finalExamExample finalExamExample = new finalExamExample();
        com.course.server.domain.finalExamExample.Criteria criteria = finalExamExample.createCriteria();

        if(!StringUtils.isEmpty(courseTargetId)){
            criteria.andCourseTargetIdEqualTo(courseTargetId);
        }
        List<finalExam> finalExamList = finalExamMapper.selectByExample(finalExamExample);

        List<finalExamDto> finalExamDtoList = CopyUtil.copyList(finalExamList, finalExamDto.class);
        if(finalExamDtoList.size() == 0){
            return null;
        }
        return finalExamDtoList.get(0);
    }

    public void save(finalExamDto finalExamDto){
        finalExam finalExam = CopyUtil.copy(finalExamDto, finalExam.class);
        CourseTargetDto courseTargetDto =  courseTargetService.getOne(finalExam.getCourseTargetId());
        finalExam.setCourseTargetName(courseTargetDto.getTarget());
        if(StringUtils.isEmpty(finalExamDto.getId())){
            this.insert(finalExam);
        }else{
            this.update(finalExam);
        }
    }

    private void insert(finalExam finalExam){
        finalExam.setId(UuidUtil.getShortUuid());
        finalExamMapper.insert(finalExam);
    }
    private void update(finalExam finalExam){
        finalExamMapper.updateByPrimaryKey(finalExam);
    }

    public void delete(String id) {
        finalExamMapper.deleteByPrimaryKey(id);
    }
}

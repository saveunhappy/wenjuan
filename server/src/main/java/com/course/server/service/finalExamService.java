package com.course.server.service;

import com.course.server.domain.finalExam;
import com.course.server.domain.finalExamExample;
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
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        finalExamExample finalExamExample = new finalExamExample();
        List<finalExam> finalExamList = finalExamMapper.selectByExample(finalExamExample);
        PageInfo pageInfo = new PageInfo(finalExamList);
        pageDto.setTotal(pageInfo.getTotal());

        List<finalExamDto> finalExamDtoList = CopyUtil.copyList(finalExamList, finalExamDto.class);
        pageDto.setList(finalExamDtoList);
    }

    public void save(finalExamDto finalExamDto){
        finalExam finalExam = CopyUtil.copy(finalExamDto, finalExam.class);

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

package com.course.server.service;

import com.course.server.domain.course_target_low;
import com.course.server.domain.course_target_lowExample;
import com.course.server.dto.course_target_lowDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.course_target_lowMapper;
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
public class course_target_lowService {
    @Resource
    private course_target_lowMapper course_target_lowMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        course_target_lowExample course_target_lowExample = new course_target_lowExample();
        List<course_target_low> course_target_lowList = course_target_lowMapper.selectByExample(course_target_lowExample);
        PageInfo pageInfo = new PageInfo(course_target_lowList);
        pageDto.setTotal(pageInfo.getTotal());

        List<course_target_lowDto> course_target_lowDtoList = CopyUtil.copyList(course_target_lowList, course_target_lowDto.class);
        pageDto.setList(course_target_lowDtoList);
    }

    public void save(course_target_lowDto course_target_lowDto){
        course_target_low course_target_low = CopyUtil.copy(course_target_lowDto, course_target_low.class);

        if(StringUtils.isEmpty(course_target_lowDto.getId())){
            this.insert(course_target_low);
        }else{
            this.update(course_target_low);
        }
    }

    private void insert(course_target_low course_target_low){
        course_target_low.setId(UuidUtil.getShortUuid());
        course_target_lowMapper.insert(course_target_low);
    }
    private void update(course_target_low course_target_low){
        course_target_lowMapper.updateByPrimaryKey(course_target_low);
    }

    public void delete(String id) {
        course_target_lowMapper.deleteByPrimaryKey(id);
    }
}

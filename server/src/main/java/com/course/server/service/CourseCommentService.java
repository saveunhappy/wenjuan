package com.course.server.service;

import com.course.server.domain.CourseComment;
import com.course.server.domain.CourseCommentExample;
import com.course.server.dto.CourseCommentDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.CourseCommentMapper;
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
public class CourseCommentService {
    @Resource
    private CourseCommentMapper courseCommentMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        CourseCommentExample courseCommentExample = new CourseCommentExample();
        List<CourseComment> courseCommentList = courseCommentMapper.selectByExample(courseCommentExample);
        PageInfo pageInfo = new PageInfo(courseCommentList);
        pageDto.setTotal(pageInfo.getTotal());

        List<CourseCommentDto> courseCommentDtoList = CopyUtil.copyList(courseCommentList, CourseCommentDto.class);
        pageDto.setList(courseCommentDtoList);
    }

    public void save(CourseCommentDto courseCommentDto){
        CourseComment courseComment = CopyUtil.copy(courseCommentDto, CourseComment.class);

        if(StringUtils.isEmpty(courseCommentDto.getId())){
            this.insert(courseComment);
        }else{
            this.update(courseComment);
        }
    }

    private void insert(CourseComment courseComment){
        courseComment.setId(UuidUtil.getShortUuid());
        courseCommentMapper.insert(courseComment);
    }
    private void update(CourseComment courseComment){
        courseCommentMapper.updateByPrimaryKey(courseComment);
    }

    public void delete(String id) {
        courseCommentMapper.deleteByPrimaryKey(id);
    }
}

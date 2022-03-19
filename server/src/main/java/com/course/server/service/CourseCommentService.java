package com.course.server.service;

import com.course.server.domain.CourseComment;
import com.course.server.domain.CourseCommentExample;
import com.course.server.domain.CourseTarget;
import com.course.server.domain.CourseTargetExample;
import com.course.server.dto.CourseCommentDto;
import com.course.server.dto.CourseTargetDto;
import com.course.server.dto.PageDto;
import com.course.server.enums.CourseCommentStatusEnum;
import com.course.server.mapper.CourseCommentMapper;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseCommentService {
    @Resource
    private CourseCommentMapper courseCommentMapper;
    @Resource
    private CourseTargetService courseTargetService;
    @Resource
    private CourseTargetMapper courseTargetMapper;
    public void list(PageDto pageDto){

        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        CourseCommentExample courseCommentExample = new CourseCommentExample();
        List<CourseComment> courseCommentList = courseCommentMapper.selectByExample(courseCommentExample);
        BigDecimal count = new BigDecimal(String.valueOf(courseCommentList.size()));
        CourseTargetExample courseTargetExample = new CourseTargetExample();
        List<CourseTarget> courseTargetList = courseTargetMapper.selectByExample(courseTargetExample);
        List<String> courseTargetIdList = courseTargetList.stream().map(CourseTarget::getId).collect(Collectors.toList());
        BigDecimal studentComments = new BigDecimal("0");
        for (String courseTargetId : courseTargetIdList) {
            BigDecimal studentComment = new BigDecimal("0");
            BigDecimal a = new BigDecimal("0");
            BigDecimal b = new BigDecimal("0");
            BigDecimal c = new BigDecimal("0");
            BigDecimal d = new BigDecimal("0");
            BigDecimal e = new BigDecimal("0");

//            BigDecimal A = new BigDecimal("0");
//            BigDecimal B = new BigDecimal("0");
//            BigDecimal C = new BigDecimal("0");
//            BigDecimal D = new BigDecimal("0");
//            BigDecimal E = new BigDecimal("0");
            //筛选出每一个id，就是每一个课程id
            CourseTargetDto targetDto = courseTargetService.getOne(courseTargetId);
            List<CourseCommentDto> courseCommentDtoList = getList(courseTargetId);
            for (CourseCommentDto courseCommentDto : courseCommentDtoList) {
                if(courseCommentDto.getCourseComment().equals(CourseCommentStatusEnum.A.getCode())){
                    a = a.add(new BigDecimal("1"));
                }else if(courseCommentDto.getCourseComment().equals(CourseCommentStatusEnum.B.getCode())){
                   b =  b.add(new BigDecimal("1"));
                }else if(courseCommentDto.getCourseComment().equals(CourseCommentStatusEnum.C.getCode())){
                   c = c.add(new BigDecimal("1"));
                }else if(courseCommentDto.getCourseComment().equals(CourseCommentStatusEnum.D.getCode())){
                  d =   d.add(new BigDecimal("1"));
                }else if(courseCommentDto.getCourseComment().equals(CourseCommentStatusEnum.E.getCode())){
                   e =  e.add(new BigDecimal("1"));
                }
            }
//            studentComment = a.multiply(new BigDecimal("1")).divide(count,2)
//                    .add(b.multiply(new BigDecimal("0.8")).divide(count,2))
//                    .add(c.multiply(new BigDecimal("0.6")).divide(count,2))
//                    .add(d.multiply(new BigDecimal("0.4")).divide(count,2))
//                    .add(e.multiply(new BigDecimal("0.2")).divide(count,2));
//
            studentComment = a.multiply(new BigDecimal("1"))
                    .add(b.multiply(new BigDecimal("0.8")))
                    .add(c.multiply(new BigDecimal("0.6")))
                    .add(d.multiply(new BigDecimal("0.4")))
                    .add(e.multiply(new BigDecimal("0.2")))
                    .divide(count,2,BigDecimal.ROUND_HALF_UP);
            targetDto.setStudentEvaluate(studentComment);
            courseTargetService.save(targetDto);
        }


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

    public List<CourseCommentDto> getList(String courseTargetId){

        CourseCommentExample courseTargetExample = new CourseCommentExample();
        CourseCommentExample.Criteria criteria = courseTargetExample.createCriteria();
        if(courseTargetId != null){
            criteria.andCourseTargetIdEqualTo(courseTargetId);
        }
        List<CourseComment> courseTargetList = courseCommentMapper.selectByExample(courseTargetExample);
        List<CourseCommentDto> CourseCommentDtos = CopyUtil.copyList(courseTargetList, CourseCommentDto.class);
        return CourseCommentDtos;
    }
}

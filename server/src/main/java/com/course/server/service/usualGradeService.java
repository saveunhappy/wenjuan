package com.course.server.service;

import com.course.server.domain.usualGrade;
import com.course.server.domain.usualGradeExample;
import com.course.server.dto.usualGradeDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.usualGradeMapper;
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
public class usualGradeService {
    @Resource
    private usualGradeMapper usualGradeMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        usualGradeExample usualGradeExample = new usualGradeExample();
        List<usualGrade> usualGradeList = usualGradeMapper.selectByExample(usualGradeExample);
        PageInfo pageInfo = new PageInfo(usualGradeList);
        pageDto.setTotal(pageInfo.getTotal());

        List<usualGradeDto> usualGradeDtoList = CopyUtil.copyList(usualGradeList, usualGradeDto.class);
        pageDto.setList(usualGradeDtoList);
    }
    public usualGradeDto getOne(String courseTargetId){
        usualGradeExample usualGradeExample = new usualGradeExample();
        com.course.server.domain.usualGradeExample.Criteria criteria = usualGradeExample.createCriteria();

        if(!StringUtils.isEmpty(courseTargetId)){
            criteria.andCourseTargetIdEqualTo(courseTargetId);
        }
        List<usualGrade> usualGradeList = usualGradeMapper.selectByExample(usualGradeExample);
        List<usualGradeDto> usualGradeDtoList = CopyUtil.copyList(usualGradeList, usualGradeDto.class);
        if(usualGradeDtoList.size() == 0){
            return  null;
        }
        return usualGradeDtoList.get(0);
    }

    public void save(usualGradeDto usualGradeDto){
        usualGrade usualGrade = CopyUtil.copy(usualGradeDto, usualGrade.class);

        if(StringUtils.isEmpty(usualGradeDto.getId())){
            this.insert(usualGrade);
        }else{
            this.update(usualGrade);
        }
    }

    private void insert(usualGrade usualGrade){
        usualGrade.setId(UuidUtil.getShortUuid());
        usualGradeMapper.insert(usualGrade);
    }
    private void update(usualGrade usualGrade){
        usualGradeMapper.updateByPrimaryKey(usualGrade);
    }

    public void delete(String id) {
        usualGradeMapper.deleteByPrimaryKey(id);
    }
}

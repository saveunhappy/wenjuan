package com.course.server.service;

import com.course.server.domain.classBehave;
import com.course.server.domain.classBehaveExample;
import com.course.server.dto.classBehaveDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.classBehaveMapper;
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
public class classBehaveService {
    @Resource
    private classBehaveMapper classBehaveMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        classBehaveExample classBehaveExample = new classBehaveExample();
        List<classBehave> classBehaveList = classBehaveMapper.selectByExample(classBehaveExample);
        PageInfo pageInfo = new PageInfo(classBehaveList);
        pageDto.setTotal(pageInfo.getTotal());

        List<classBehaveDto> classBehaveDtoList = CopyUtil.copyList(classBehaveList, classBehaveDto.class);
        pageDto.setList(classBehaveDtoList);
    }

    public void save(classBehaveDto classBehaveDto){
        classBehave classBehave = CopyUtil.copy(classBehaveDto, classBehave.class);

        if(StringUtils.isEmpty(classBehaveDto.getId())){
            this.insert(classBehave);
        }else{
            this.update(classBehave);
        }
    }

    private void insert(classBehave classBehave){
        classBehave.setId(UuidUtil.getShortUuid());
        classBehaveMapper.insert(classBehave);
    }
    private void update(classBehave classBehave){
        classBehaveMapper.updateByPrimaryKey(classBehave);
    }

    public void delete(String id) {
        classBehaveMapper.deleteByPrimaryKey(id);
    }
}

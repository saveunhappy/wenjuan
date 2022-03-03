package com.course.server.service;

import com.course.server.domain.Apply;
import com.course.server.domain.ApplyExample;
import com.course.server.dto.ApplyDto;
import com.course.server.dto.ApplyPageDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ApplyMapper;
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
import java.util.Date;
@Service
public class ApplyService {
    @Resource
    private ApplyMapper applyMapper;
    public void list(ApplyPageDto applyPageDto){
        PageHelper.startPage(applyPageDto.getPage(),applyPageDto.getSize());
        ApplyExample applyExample = new ApplyExample();
        ApplyExample.Criteria criteria = applyExample.createCriteria();
        if(!StringUtils.isEmpty(applyPageDto.getStatus())){
            criteria.andStatusEqualTo(applyPageDto.getStatus());
        }
        List<Apply> applyList = applyMapper.selectByExample(applyExample);
        PageInfo pageInfo = new PageInfo(applyList);
        applyPageDto.setTotal(pageInfo.getTotal());

        List<ApplyDto> applyDtoList = CopyUtil.copyList(applyList, ApplyDto.class);
        applyPageDto.setList(applyDtoList);
    }

    public void save(ApplyDto applyDto){
        Apply apply = CopyUtil.copy(applyDto, Apply.class);

        if(StringUtils.isEmpty(applyDto.getId())){
            this.insert(apply);
        }else{
            this.update(apply);
        }
    }

    private void insert(Apply apply){
        Date now = new Date();
        apply.setCreatedAt(now);
        apply.setUpdatedAt(now);
        apply.setId(UuidUtil.getShortUuid());
        applyMapper.insert(apply);
    }
    private void update(Apply apply){
        apply.setUpdatedAt(new Date());
        applyMapper.updateByPrimaryKey(apply);
    }

    public void delete(String id) {
        applyMapper.deleteByPrimaryKey(id);
    }
}

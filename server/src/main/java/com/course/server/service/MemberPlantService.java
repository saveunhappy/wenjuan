package com.course.server.service;

import com.course.server.domain.Member;
import com.course.server.domain.MemberPlant;
import com.course.server.domain.MemberPlantExample;
import com.course.server.domain.Plant;
import com.course.server.dto.MemberPlantDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.PlantDto;
import com.course.server.enums.PlantStatusEnum;
import com.course.server.mapper.MemberPlantMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
@Service
public class MemberPlantService {
    @Resource
    private MemberPlantMapper memberPlantMapper;
    @Resource
    private PlantService plantService;
    @Resource
    private MemberService memberService;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        MemberPlantExample memberPlantExample = new MemberPlantExample();
        List<MemberPlant> memberPlantList = memberPlantMapper.selectByExample(memberPlantExample);
        PageInfo pageInfo = new PageInfo(memberPlantList);
        pageDto.setTotal(pageInfo.getTotal());

        List<MemberPlantDto> memberPlantDtoList = CopyUtil.copyList(memberPlantList, MemberPlantDto.class);
        for (MemberPlantDto memberPlantDto : memberPlantDtoList) {
            if(memberPlantDto.getPlantId()!= null && memberPlantDto.getMemberId()!= null){
                Plant plant = plantService.findOne(memberPlantDto.getPlantId());
                memberPlantDto.setPlantId(plant.getName());
                Member member = memberService.findOne(memberPlantDto.getMemberId());
                memberPlantDto.setMemberId(member.getName());
            }
        }
        pageDto.setList(memberPlantDtoList);
    }

    public void myadopt(MemberPlantDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        MemberPlantExample memberPlantExample = new MemberPlantExample();
        MemberPlantExample.Criteria criteria = memberPlantExample.createCriteria();
        if(!StringUtils.isEmpty(pageDto.getMemberId())){
            criteria.andMemberIdEqualTo(pageDto.getMemberId());
        }
        List<MemberPlant> memberPlantList = memberPlantMapper.selectByExample(memberPlantExample);
        PageInfo pageInfo = new PageInfo(memberPlantList);
        pageDto.setTotal(pageInfo.getTotal());

        List<MemberPlantDto> memberPlantDtoList = CopyUtil.copyList(memberPlantList, MemberPlantDto.class);
        List<PlantDto> plantDtoList = new ArrayList<>();
        for (MemberPlantDto memberPlantDto : memberPlantDtoList) {

            PlantDto plant = plantService.findPlantNoCondition(memberPlantDto.getPlantId());
            plantDtoList.add(plant);
        }
        pageDto.setList(plantDtoList);
    }


    public void save(MemberPlantDto memberPlantDto){
        MemberPlant memberPlant = CopyUtil.copy(memberPlantDto, MemberPlant.class);

        if(StringUtils.isEmpty(memberPlantDto.getId())){
            this.insert(memberPlant);
        }else{
            this.update(memberPlant);
        }
    }
    public MemberPlantDto adopt(MemberPlantDto memberPlantDto){
        MemberPlant memberPlantDb = this.select(memberPlantDto.getMemberId(), memberPlantDto.getPlantId());
        if(memberPlantDb == null){
            MemberPlant memberPlant = CopyUtil.copy(memberPlantDto, MemberPlant.class);
            this.insert(memberPlant);
            return CopyUtil.copy(memberPlant,MemberPlantDto.class);
        }else{
            return CopyUtil.copy(memberPlantDb,MemberPlantDto.class);
        }

    }
    /**
     * 根据memberId和courseId查询记录
     */
    public MemberPlant select(String memberId, String courseId) {
        MemberPlantExample example = new MemberPlantExample();
        example.createCriteria()
                .andPlantIdEqualTo(courseId)
                .andMemberIdEqualTo(memberId);
        List<MemberPlant> memberCourseList = memberPlantMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(memberCourseList)) {
            return null;
        } else {
            return memberCourseList.get(0);
        }
    }

    private void insert(MemberPlant memberPlant){
        Date now = new Date();
        memberPlant.setId(UuidUtil.getShortUuid());
        memberPlant.setAt(now);
        memberPlantMapper.insert(memberPlant);
    }
    private void update(MemberPlant memberPlant){
        memberPlantMapper.updateByPrimaryKey(memberPlant);
    }

    public void delete(String id) {
        memberPlantMapper.deleteByPrimaryKey(id);
    }

    public MemberPlantDto getEnroll(MemberPlantDto memberPlantDto) {
        MemberPlant select = this.select(memberPlantDto.getMemberId(), memberPlantDto.getPlantId());
        return CopyUtil.copy(select,MemberPlantDto.class);

    }
    @Transactional
    public void cancelAdopt(MemberPlantDto memberPlantDto) {
        PageHelper.startPage(memberPlantDto.getPage(),memberPlantDto.getSize());
        MemberPlantExample memberPlantExample = new MemberPlantExample();
        MemberPlantExample.Criteria criteria = memberPlantExample.createCriteria();
        if(!StringUtils.isEmpty(memberPlantDto.getPlantId())){
            PlantDto plantNoCondition = plantService.findPlantNoCondition(memberPlantDto.getPlantId());
            plantNoCondition.setStatus(PlantStatusEnum.NO.getCode());
            plantService.save(plantNoCondition);
            criteria.andPlantIdEqualTo(memberPlantDto.getPlantId());
        }
        if(!StringUtils.isEmpty(memberPlantDto.getMemberId())){
            criteria.andMemberIdEqualTo(memberPlantDto.getMemberId());
        }

        List<MemberPlant> memberPlantList = memberPlantMapper.selectByExample(memberPlantExample);
        if(!CollectionUtils.isEmpty(memberPlantList)){
            for (MemberPlant memberPlant : memberPlantList) {
                memberPlantMapper.deleteByPrimaryKey(memberPlant.getId());
            }
        }
        PageInfo pageInfo = new PageInfo(memberPlantList);
        memberPlantDto.setTotal(pageInfo.getTotal());

        List<MemberPlantDto> memberPlantDtoList = CopyUtil.copyList(memberPlantList, MemberPlantDto.class);

        memberPlantDto.setList(memberPlantDtoList);

    }
}

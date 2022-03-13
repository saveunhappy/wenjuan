package com.course.server.service;

import com.course.server.domain.AvgScore;
import com.course.server.domain.AvgScoreExample;
import com.course.server.dto.AvgScoreDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.AvgScoreMapper;
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
public class AvgScoreService {
    @Resource
    private AvgScoreMapper avgScoreMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        AvgScoreExample avgScoreExample = new AvgScoreExample();
        List<AvgScore> avgScoreList = avgScoreMapper.selectByExample(avgScoreExample);
        PageInfo pageInfo = new PageInfo(avgScoreList);
        pageDto.setTotal(pageInfo.getTotal());

        List<AvgScoreDto> avgScoreDtoList = CopyUtil.copyList(avgScoreList, AvgScoreDto.class);
        pageDto.setList(avgScoreDtoList);
    }

    public void save(AvgScoreDto avgScoreDto){
        AvgScore avgScore = CopyUtil.copy(avgScoreDto, AvgScore.class);
        avgScore.setId(avgScoreDto.getId());
        avgScoreMapper.insert(avgScore);
//        if(StringUtils.isEmpty(avgScoreDto.getId())){
//            this.insert(avgScore);
//        }else{
//            this.update(avgScore);
//        }
    }

    private void insert(AvgScore avgScore){
        avgScore.setId(UuidUtil.getShortUuid());
        avgScoreMapper.insert(avgScore);
    }
    private void update(AvgScore avgScore){
        avgScoreMapper.updateByPrimaryKey(avgScore);
    }

    public void delete(String id) {
        avgScoreMapper.deleteByPrimaryKey(id);
    }
}

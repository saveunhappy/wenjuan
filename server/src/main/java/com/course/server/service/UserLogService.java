package com.course.server.service;

import com.course.server.domain.UserLog;
import com.course.server.domain.UserLogExample;
import com.course.server.dto.UserLogDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.UserLogPageDto;
import com.course.server.mapper.UserLogMapper;
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
public class UserLogService {
    @Resource
    private UserLogMapper userLogMapper;
    public void list(UserLogPageDto userLogPageDto){
        PageHelper.startPage(userLogPageDto.getPage(),userLogPageDto.getSize());
        UserLogExample userLogExample = new UserLogExample();
        UserLogExample.Criteria criteria = userLogExample.createCriteria();
        if (!StringUtils.isEmpty(userLogPageDto.getStatus())){
            criteria.andStatusEqualTo(userLogPageDto.getStatus());
        }
        List<UserLog> userLogList = userLogMapper.selectByExample(userLogExample);
        PageInfo pageInfo = new PageInfo(userLogList);
        userLogPageDto.setTotal(pageInfo.getTotal());

        List<UserLogDto> userLogDtoList = CopyUtil.copyList(userLogList, UserLogDto.class);
        userLogPageDto.setList(userLogDtoList);
    }

    public void save(UserLogDto userLogDto){
        UserLog userLog = CopyUtil.copy(userLogDto, UserLog.class);

        if(StringUtils.isEmpty(userLogDto.getId())){
            this.insert(userLog);
        }else{
            this.update(userLog);
        }
    }

    private void insert(UserLog userLog){
        Date now = new Date();
        userLog.setCreatedAt(now);
        userLog.setUpdatedAt(now);
        userLog.setId(UuidUtil.getShortUuid());
        userLogMapper.insert(userLog);
    }
    private void update(UserLog userLog){
        userLog.setUpdatedAt(new Date());
        userLogMapper.updateByPrimaryKey(userLog);
    }

    public void delete(String id) {
        userLogMapper.deleteByPrimaryKey(id);
    }
}

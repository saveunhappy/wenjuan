package com.course.server.mapper;

import com.course.server.domain.classBehave;
import com.course.server.domain.classBehaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface classBehaveMapper {
    long countByExample(classBehaveExample example);

    int deleteByExample(classBehaveExample example);

    int deleteByPrimaryKey(String id);

    int insert(classBehave record);

    int insertSelective(classBehave record);

    List<classBehave> selectByExample(classBehaveExample example);

    classBehave selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") classBehave record, @Param("example") classBehaveExample example);

    int updateByExample(@Param("record") classBehave record, @Param("example") classBehaveExample example);

    int updateByPrimaryKeySelective(classBehave record);

    int updateByPrimaryKey(classBehave record);
}
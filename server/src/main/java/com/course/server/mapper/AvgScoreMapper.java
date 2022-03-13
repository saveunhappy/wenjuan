package com.course.server.mapper;

import com.course.server.domain.AvgScore;
import com.course.server.domain.AvgScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AvgScoreMapper {
    long countByExample(AvgScoreExample example);

    int deleteByExample(AvgScoreExample example);

    int deleteByPrimaryKey(String id);

    int insert(AvgScore record);

    int insertSelective(AvgScore record);

    List<AvgScore> selectByExample(AvgScoreExample example);

    AvgScore selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AvgScore record, @Param("example") AvgScoreExample example);

    int updateByExample(@Param("record") AvgScore record, @Param("example") AvgScoreExample example);

    int updateByPrimaryKeySelective(AvgScore record);

    int updateByPrimaryKey(AvgScore record);
}
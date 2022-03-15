package com.course.server.mapper;

import com.course.server.domain.CourseTargetLow;
import com.course.server.domain.CourseTargetLowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTargetLowMapper {
    long countByExample(CourseTargetLowExample example);

    int deleteByExample(CourseTargetLowExample example);

    int deleteByPrimaryKey(String id);

    int insert(CourseTargetLow record);

    int insertSelective(CourseTargetLow record);

    List<CourseTargetLow> selectByExample(CourseTargetLowExample example);

    CourseTargetLow selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CourseTargetLow record, @Param("example") CourseTargetLowExample example);

    int updateByExample(@Param("record") CourseTargetLow record, @Param("example") CourseTargetLowExample example);

    int updateByPrimaryKeySelective(CourseTargetLow record);

    int updateByPrimaryKey(CourseTargetLow record);
}
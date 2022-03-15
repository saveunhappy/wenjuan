package com.course.server.mapper;

import com.course.server.domain.CourseTarget;
import com.course.server.domain.CourseTargetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTargetMapper {
    long countByExample(CourseTargetExample example);

    int deleteByExample(CourseTargetExample example);

    int deleteByPrimaryKey(String id);

    int insert(CourseTarget record);

    int insertSelective(CourseTarget record);

    List<CourseTarget> selectByExample(CourseTargetExample example);

    CourseTarget selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CourseTarget record, @Param("example") CourseTargetExample example);

    int updateByExample(@Param("record") CourseTarget record, @Param("example") CourseTargetExample example);

    int updateByPrimaryKeySelective(CourseTarget record);

    int updateByPrimaryKey(CourseTarget record);
}
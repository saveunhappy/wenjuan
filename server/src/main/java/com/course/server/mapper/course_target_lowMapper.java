package com.course.server.mapper;

import com.course.server.domain.course_target_low;
import com.course.server.domain.course_target_lowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface course_target_lowMapper {
    long countByExample(course_target_lowExample example);

    int deleteByExample(course_target_lowExample example);

    int deleteByPrimaryKey(String id);

    int insert(course_target_low record);

    int insertSelective(course_target_low record);

    List<course_target_low> selectByExample(course_target_lowExample example);

    course_target_low selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") course_target_low record, @Param("example") course_target_lowExample example);

    int updateByExample(@Param("record") course_target_low record, @Param("example") course_target_lowExample example);

    int updateByPrimaryKeySelective(course_target_low record);

    int updateByPrimaryKey(course_target_low record);
}
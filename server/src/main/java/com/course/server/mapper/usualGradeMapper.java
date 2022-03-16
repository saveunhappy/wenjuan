package com.course.server.mapper;

import com.course.server.domain.usualGrade;
import com.course.server.domain.usualGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface usualGradeMapper {
    long countByExample(usualGradeExample example);

    int deleteByExample(usualGradeExample example);

    int deleteByPrimaryKey(String id);

    int insert(usualGrade record);

    int insertSelective(usualGrade record);

    List<usualGrade> selectByExample(usualGradeExample example);

    usualGrade selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") usualGrade record, @Param("example") usualGradeExample example);

    int updateByExample(@Param("record") usualGrade record, @Param("example") usualGradeExample example);

    int updateByPrimaryKeySelective(usualGrade record);

    int updateByPrimaryKey(usualGrade record);
}
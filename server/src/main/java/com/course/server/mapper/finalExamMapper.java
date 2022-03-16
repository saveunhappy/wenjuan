package com.course.server.mapper;

import com.course.server.domain.finalExam;
import com.course.server.domain.finalExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface finalExamMapper {
    long countByExample(finalExamExample example);

    int deleteByExample(finalExamExample example);

    int deleteByPrimaryKey(String id);

    int insert(finalExam record);

    int insertSelective(finalExam record);

    List<finalExam> selectByExample(finalExamExample example);

    finalExam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") finalExam record, @Param("example") finalExamExample example);

    int updateByExample(@Param("record") finalExam record, @Param("example") finalExamExample example);

    int updateByPrimaryKeySelective(finalExam record);

    int updateByPrimaryKey(finalExam record);
}
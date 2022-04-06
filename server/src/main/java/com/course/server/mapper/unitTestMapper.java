package com.course.server.mapper;

import com.course.server.domain.unitTest;
import com.course.server.domain.unitTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface unitTestMapper {
    long countByExample(unitTestExample example);

    int deleteByExample(unitTestExample example);

    int deleteByPrimaryKey(String id);

    int insert(unitTest record);

    int insertSelective(unitTest record);

    List<unitTest> selectByExample(unitTestExample example);

    unitTest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") unitTest record, @Param("example") unitTestExample example);

    int updateByExample(@Param("record") unitTest record, @Param("example") unitTestExample example);

    int updateByPrimaryKeySelective(unitTest record);

    int updateByPrimaryKey(unitTest record);
}
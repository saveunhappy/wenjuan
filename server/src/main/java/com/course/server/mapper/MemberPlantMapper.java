package com.course.server.mapper;

import com.course.server.domain.MemberPlant;
import com.course.server.domain.MemberPlantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberPlantMapper {
    long countByExample(MemberPlantExample example);

    int deleteByExample(MemberPlantExample example);

    int deleteByPrimaryKey(String id);

    int insert(MemberPlant record);

    int insertSelective(MemberPlant record);

    List<MemberPlant> selectByExample(MemberPlantExample example);

    MemberPlant selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MemberPlant record, @Param("example") MemberPlantExample example);

    int updateByExample(@Param("record") MemberPlant record, @Param("example") MemberPlantExample example);

    int updateByPrimaryKeySelective(MemberPlant record);

    int updateByPrimaryKey(MemberPlant record);
}
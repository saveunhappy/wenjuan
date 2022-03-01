package com.course.server.mapper;

import com.course.server.domain.Plant;
import com.course.server.domain.PlantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlantMapper {
    long countByExample(PlantExample example);

    int deleteByExample(PlantExample example);

    int deleteByPrimaryKey(String id);

    int insert(Plant record);

    int insertSelective(Plant record);

    List<Plant> selectByExample(PlantExample example);

    Plant selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Plant record, @Param("example") PlantExample example);

    int updateByExample(@Param("record") Plant record, @Param("example") PlantExample example);

    int updateByPrimaryKeySelective(Plant record);

    int updateByPrimaryKey(Plant record);
}
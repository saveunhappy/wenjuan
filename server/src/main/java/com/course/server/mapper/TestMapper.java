package com.course.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.course.server.domain.Test;

import java.util.List;

@Mapper
public interface TestMapper {
    List<Test> list();
}

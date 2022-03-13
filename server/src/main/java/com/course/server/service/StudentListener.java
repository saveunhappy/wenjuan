package com.course.server.service;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.course.server.domain.Student;
import com.course.server.mapper.StudentMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentListener extends AnalysisEventListener<Student> {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        studentMapper.insert(student);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

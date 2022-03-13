package com.course.server.service;

import com.course.server.domain.Student;
import com.course.server.domain.StudentExample;
import com.course.server.dto.AvgScoreDto;
import com.course.server.dto.StudentDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.AvgScoreMapper;
import com.course.server.mapper.StudentMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    public static final String AVG_ID = "00000000";
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private AvgScoreMapper avgScoreMapper;
    @Resource
    private AvgScoreService avgScoreService;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        StudentExample studentExample = new StudentExample();
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        avgScoreMapper.deleteByPrimaryKey(AVG_ID);
        BigDecimal finalExamAvg = new BigDecimal("0.00");
        BigDecimal usualGradeAvg = new BigDecimal("0.00");
        BigDecimal unitTestAvg = new BigDecimal("0.00");
        BigDecimal classBehaveAvg = new BigDecimal("0.00");
        for (Student student : studentList) {
            BigDecimal finalExam = student.getFinalExam();
            BigDecimal usualGrade = student.getUsualGrade();
            BigDecimal unitTest = student.getUnitTest();
            BigDecimal classBehave = student.getClassBehave();
            BigDecimal comprehension = finalExam.multiply(new BigDecimal("0.6"))
                    .add(usualGrade.multiply(new BigDecimal("0.1")))
                    .add(unitTest.multiply(new BigDecimal("0.2")))
                    .add(classBehave.multiply(new BigDecimal("0.1")));
            student.setFinalResult(comprehension);
            studentMapper.updateByPrimaryKeySelective(student);
            finalExamAvg = finalExamAvg.add(finalExam);
            usualGradeAvg = usualGradeAvg.add(usualGrade);
            unitTestAvg = unitTestAvg.add(unitTest);
            classBehaveAvg = classBehaveAvg.add(classBehave);
        }
        AvgScoreDto avgScoreDto = new AvgScoreDto();
        avgScoreDto.setId(AVG_ID);
        avgScoreDto.setFinalExamAvg(finalExamAvg);
        avgScoreDto.setUnitTestAvg(usualGradeAvg);
        avgScoreDto.setUsualGradeAvg(usualGradeAvg);
        avgScoreDto.setClassBehaveAvg(classBehaveAvg);
        avgScoreService.save(avgScoreDto);

        PageInfo pageInfo = new PageInfo(studentList);
        pageDto.setTotal(pageInfo.getTotal());

        List<StudentDto> studentDtoList = CopyUtil.copyList(studentList, StudentDto.class);
        pageDto.setList(studentDtoList);
    }

    public void save(StudentDto studentDto){
        Student student = CopyUtil.copy(studentDto, Student.class);

        if(StringUtils.isEmpty(studentDto.getId())){
            this.insert(student);
        }else{
            this.update(student);
        }
    }

    private void insert(Student student){
        student.setId(UuidUtil.getShortUuid());
        studentMapper.insert(student);
    }
    private void update(Student student){
        studentMapper.updateByPrimaryKey(student);
    }

    public void delete(String id) {
        studentMapper.deleteByPrimaryKey(id);
    }
}

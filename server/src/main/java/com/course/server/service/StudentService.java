package com.course.server.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.course.server.domain.Student;
import com.course.server.domain.StudentExample;
import com.course.server.dto.AvgScoreDto;
import com.course.server.dto.StudentDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.StudentExcellDto;
import com.course.server.mapper.AvgScoreMapper;
import com.course.server.mapper.StudentMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
        avgScoreDto.setFinalExamAvg(divideGetAvg(finalExamAvg,studentList));
        avgScoreDto.setUnitTestAvg(divideGetAvg(unitTestAvg,studentList));
        avgScoreDto.setUsualGradeAvg(divideGetAvg(usualGradeAvg,studentList));
        avgScoreDto.setClassBehaveAvg(divideGetAvg(classBehaveAvg,studentList));
        avgScoreService.save(avgScoreDto);

        PageInfo pageInfo = new PageInfo(studentList);
        pageDto.setTotal(pageInfo.getTotal());

        List<StudentDto> studentDtoList = CopyUtil.copyList(studentList, StudentDto.class);
        pageDto.setList(studentDtoList);
    }
    public static BigDecimal divideGetAvg(BigDecimal bigDecimal,List studentList){
        if(studentList.size()==0){
            return new BigDecimal("0");
        }
        return bigDecimal.divide(new BigDecimal(String.valueOf(studentList.size())),2,BigDecimal.ROUND_HALF_UP);
    }
    public void save(StudentDto studentDto){
        Student student = CopyUtil.copy(studentDto, Student.class);

        if(StringUtils.isEmpty(studentDto.getId())){
            this.insert(student);
        }else{
            this.update(student);
        }
    }

    public void insert(Student student){
        student.setId(UuidUtil.getShortUuid());
        studentMapper.insert(student);
    }
    private void update(Student student){
        studentMapper.updateByPrimaryKey(student);
    }

    public void delete(String id) {
        studentMapper.deleteByPrimaryKey(id);
    }


    public void upload(){
        StudentExample studentExample = new StudentExample();
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        for (Student student : studentList) {
            studentMapper.deleteByPrimaryKey(student.getId());
        }
        EasyExcel.read("D:\\axiaoyun\\wenjuan\\server\\aaa.xlsx", Student.class, new PageReadListener<Student>(dataList -> {
            for (Student student : dataList) {
                student.setId(UuidUtil.getShortUuid());

                studentMapper.insert(student);
            }
        })).sheet().doRead();
    }

    public void deleteAll(){
        StudentExample studentExample = new StudentExample();
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        for (Student student : studentList) {
            studentMapper.deleteByPrimaryKey(student.getId());
        }
        avgScoreMapper.deleteByPrimaryKey(AVG_ID);

        List<StudentDto> studentDtoList = CopyUtil.copyList(studentList, StudentDto.class);
    }
    public List<StudentExcellDto> selectAll(){
        StudentExample studentExample = new StudentExample();
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        List<StudentExcellDto> studentDtoList = CopyUtil.copyList(studentList, StudentExcellDto.class);
        return studentDtoList;
    }
}

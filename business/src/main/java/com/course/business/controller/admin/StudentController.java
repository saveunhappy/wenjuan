package com.course.business.controller.admin;

import com.course.server.dto.StudentDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.StudentService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/student")
public class StudentController {
    public static final String BUSINESS_NAME = "学生";
    @Resource
    private StudentService studentService;
    @PostMapping("/list")
    public ResponseDto student(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        studentService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody StudentDto studentDto){
        // 保存校验
        ValidatorUtil.length(studentDto.getClassName(), "班级", 1, 50);
        ValidatorUtil.length(studentDto.getStudentNumber(), "学号", 1, 50);
        ValidatorUtil.length(studentDto.getName(), "姓名", 1, 32);

        ResponseDto responseDto = new ResponseDto();
        studentService.save(studentDto);
        responseDto.setContent(studentDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        studentService.delete(id);
        return responseDto;
    }

}

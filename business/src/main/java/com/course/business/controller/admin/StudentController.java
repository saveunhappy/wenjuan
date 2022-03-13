package com.course.business.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.course.server.domain.Student;
import com.course.server.dto.StudentDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.StudentService;
import com.course.server.util.UuidUtil;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

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

//    @GetMapping("/upload")
//    public ResponseDto upload(){
//        ResponseDto responseDto = new ResponseDto();
//        studentService.upload();
//        return responseDto;
//    }

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link }
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{}
     * <p>3. 直接读即可
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseDto upload(MultipartFile file) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        EasyExcel.read(file.getInputStream(), Student.class, new PageReadListener<Student>(dataList -> {
            for (Student student : dataList) {
                student.setId(UuidUtil.getShortUuid());
                studentService.insert(student);
            }
        })).sheet().doRead();
        return responseDto;
    }
}

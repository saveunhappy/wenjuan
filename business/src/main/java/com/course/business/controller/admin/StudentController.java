package com.course.business.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.course.server.domain.Student;
import com.course.server.dto.*;
import com.course.server.exception.BusinessException;
import com.course.server.exception.BusinessExceptionCode;
import com.course.server.service.AvgScoreService;
import com.course.server.service.StudentService;
import com.course.server.util.UuidUtil;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/student")
public class StudentController {
    public static final String BUSINESS_NAME = "学生";
    @Resource
    private StudentService studentService;
    @Resource
    private AvgScoreService avgScoreService;
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

    @PostMapping("/deleteAll")
    public ResponseDto deleteAll(){
        ResponseDto responseDto = new ResponseDto();
        studentService.deleteAll();
        return responseDto;
    }
    @GetMapping("download")
    public ResponseDto download(HttpServletResponse response) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("计算机应用基础20级", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), StudentExcellDto.class).sheet("模板").doWrite(data());

//        String fileName = "测试测试.xlsx";


//        try {
//            EasyExcel.write(fileName, StudentExcellDto.class).sheet("sheet1").doWrite(data());
//        } catch (Exception e) {
//            throw new BusinessException(BusinessExceptionCode.FILE_NOT_FOUND);
//        }
        return responseDto;
    }

    private List<StudentExcellDto> data() {
        List<StudentExcellDto> studentExcellDtos = studentService.selectAll();
        return studentExcellDtos;
    }

    private List<AvgScoreDto> avg() {
        List<AvgScoreDto> avg = avgScoreService.getAvg();
        return avg;
    }
}

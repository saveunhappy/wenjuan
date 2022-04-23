package com.course.business.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.course.server.domain.CourseComment;
import com.course.server.domain.Student;
import com.course.server.dto.CourseCommentDto;
import com.course.server.dto.CourseTargetDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseCommentService;
import com.course.server.service.CourseTargetService;
import com.course.server.util.UuidUtil;
import com.course.server.util.ValidatorUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/admin/courseComment")
public class CourseCommentController {
    public static final String BUSINESS_NAME = "课程目标";
    @Resource
    private CourseCommentService courseCommentService;
    @Resource
    private CourseTargetService courseTargetService;
    @PostMapping("/list")
    @ApiOperation(value = "查看课程评价列表",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto courseComment(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        courseCommentService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    @ApiOperation(value = "新增课程评价",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto save(@RequestBody CourseCommentDto courseCommentDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        courseCommentService.save(courseCommentDto);
        responseDto.setContent(courseCommentDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除课程评价",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        courseCommentService.delete(id);
        return responseDto;
    }

    @PostMapping("/deleteAll")
    @ApiOperation(value = "删除所有课程评价",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto deleteAll(){
        ResponseDto responseDto = new ResponseDto();
        courseCommentService.deleteAll();
        return responseDto;
    }

    @PostMapping("/upload")
    @ApiOperation(value = "上传课程评价文件",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    @ResponseBody
    public ResponseDto upload(MultipartFile file,String courseTargetId) throws IOException {

        ResponseDto responseDto = new ResponseDto();
        String courseTargetIdFromHtml = courseTargetId;
        CourseTargetDto courseTargetDto = courseTargetService.getOne(courseTargetIdFromHtml);
        String targetName = courseTargetDto.getTarget();
        EasyExcel.read(file.getInputStream(), CourseCommentDto.class, new PageReadListener<CourseCommentDto>(dataList -> {
            for (CourseCommentDto courseCommentDto : dataList) {
                courseCommentDto.setCourseTargetId(courseTargetIdFromHtml);
                courseCommentDto.setCourseComment(courseCommentDto.getCourseComment().substring(0,1));
                courseCommentDto.setCourseTargetName(targetName);
                courseCommentService.save(courseCommentDto);
                System.out.println(courseCommentDto);
//                student.setId(UuidUtil.getShortUuid());
//                studentService.insert(student);
            }
        })).sheet().doRead();
        return responseDto;
    }

}

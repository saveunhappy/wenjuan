package com.course.business.controller.admin;

import com.course.server.dto.CourseCommentDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseCommentService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/courseComment")
public class CourseCommentController {
    public static final String BUSINESS_NAME = "课程目标";
    @Resource
    private CourseCommentService courseCommentService;
    @PostMapping("/list")
    public ResponseDto courseComment(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        courseCommentService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseCommentDto courseCommentDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        courseCommentService.save(courseCommentDto);
        responseDto.setContent(courseCommentDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        courseCommentService.delete(id);
        return responseDto;
    }

}

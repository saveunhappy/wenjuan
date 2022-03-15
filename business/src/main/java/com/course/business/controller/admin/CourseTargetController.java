package com.course.business.controller.admin;

import com.course.server.dto.CourseTargetDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseTargetService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/courseTarget")
public class CourseTargetController {
    public static final String BUSINESS_NAME = "课程目标";
    @Resource
    private CourseTargetService courseTargetService;
    @PostMapping("/list")
    public ResponseDto courseTarget(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        courseTargetService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseTargetDto courseTargetDto){
        // 保存校验
        ValidatorUtil.length(courseTargetDto.getTarget(), "课程目标", 1, 200);

        ResponseDto responseDto = new ResponseDto();
        courseTargetService.save(courseTargetDto);
        responseDto.setContent(courseTargetDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        courseTargetService.delete(id);
        return responseDto;
    }

}

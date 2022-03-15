package com.course.business.controller.admin;

import com.course.server.dto.CourseTargetLowDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseTargetLowService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/courseTargetLow")
public class CourseTargetLowController {
    public static final String BUSINESS_NAME = "课程目标";
    @Resource
    private CourseTargetLowService courseTargetLowService;
    @PostMapping("/list")
    public ResponseDto courseTargetLow(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        courseTargetLowService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseTargetLowDto courseTargetLowDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        courseTargetLowService.save(courseTargetLowDto);
        responseDto.setContent(courseTargetLowDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        courseTargetLowService.delete(id);
        return responseDto;
    }

}

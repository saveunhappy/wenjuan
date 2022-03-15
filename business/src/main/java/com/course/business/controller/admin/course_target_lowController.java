package com.course.business.controller.admin;

import com.course.server.dto.course_target_lowDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.course_target_lowService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/course_target_low")
public class course_target_lowController {
    public static final String BUSINESS_NAME = "课程目标";
    @Resource
    private course_target_lowService course_target_lowService;
    @PostMapping("/list")
    public ResponseDto course_target_low(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        course_target_lowService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody course_target_lowDto course_target_lowDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        course_target_lowService.save(course_target_lowDto);
        responseDto.setContent(course_target_lowDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        course_target_lowService.delete(id);
        return responseDto;
    }

}

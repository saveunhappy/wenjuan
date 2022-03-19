package com.course.business.controller.admin;

import com.course.server.dto.finalExamDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.finalExamService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/finalExam")
public class finalExamController {
    public static final String BUSINESS_NAME = "结课考试";
    @Resource
    private finalExamService finalExamService;
    @PostMapping("/list")
    public ResponseDto finalExam(@RequestBody finalExamDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        finalExamService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody finalExamDto finalExamDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        finalExamService.save(finalExamDto);
        responseDto.setContent(finalExamDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        finalExamService.delete(id);
        return responseDto;
    }

}

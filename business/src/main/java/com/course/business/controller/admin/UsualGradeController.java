package com.course.business.controller.admin;

import com.course.server.dto.usualGradeDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.usualGradeService;
import com.course.server.util.ValidatorUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/usualGrade")
public class UsualGradeController {
    public static final String BUSINESS_NAME = "平时作业";
    @Resource
    private usualGradeService usualGradeService;
    @PostMapping("/list")
    @ApiOperation(value = "查看平时成绩列表",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto usualGrade(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        usualGradeService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    @ApiOperation(value = "新增平时成绩",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto save(@RequestBody usualGradeDto usualGradeDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        usualGradeService.save(usualGradeDto);
        responseDto.setContent(usualGradeDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除平时成绩",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        usualGradeService.delete(id);
        return responseDto;
    }

}

package com.course.business.controller.admin;

import com.course.server.dto.unitTestDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.unitTestService;
import com.course.server.util.ValidatorUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/unitTest")
public class UnitTestController {
    public static final String BUSINESS_NAME = "平时作业";
    @Resource
    private unitTestService unitTestService;
    @PostMapping("/list")
    @ApiOperation(value = "查看单元测试列表",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto unitTest(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        unitTestService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    @ApiOperation(value = "新增单元测试",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto save(@RequestBody unitTestDto unitTestDto){
        // 保存校验
        ValidatorUtil.length(unitTestDto.getCourseTargetName(), "课程目标名称", 1, 200);

        ResponseDto responseDto = new ResponseDto();
        unitTestService.save(unitTestDto);
        responseDto.setContent(unitTestDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除单元测试",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        unitTestService.delete(id);
        return responseDto;
    }

}

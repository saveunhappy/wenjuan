package com.course.business.controller.admin;

import com.course.server.dto.classBehaveDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.classBehaveService;
import com.course.server.util.ValidatorUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/classBehave")
public class ClassBehaveController {
    public static final String BUSINESS_NAME = "课堂表现";
    @Resource
    private classBehaveService classBehaveService;
    @PostMapping("/list")
    @ApiOperation(value = "查看课堂表现列表",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto classBehave(@RequestBody classBehaveDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        classBehaveService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    @ApiOperation(value = "新增课堂表现",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto save(@RequestBody classBehaveDto classBehaveDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        classBehaveService.save(classBehaveDto);
        responseDto.setContent(classBehaveDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除课堂表现",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        classBehaveService.delete(id);
        return responseDto;
    }

}

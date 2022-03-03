package com.course.business.controller.admin;

import com.course.server.dto.PlantDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.PlantService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/plant")
public class PlantController {
    public static final String BUSINESS_NAME = "用户";
    @Resource
    private PlantService plantService;
    @PostMapping("/list")
    public ResponseDto plant(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        plantService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody PlantDto plantDto){
        // 保存校验
        ValidatorUtil.require(plantDto.getName(), "绿植名称");
        ValidatorUtil.length(plantDto.getName(), "绿植名称", 1, 50);
        ValidatorUtil.length(plantDto.getSummary(), "概述", 1, 2000);
        ValidatorUtil.length(plantDto.getImage(), "绿植封面", 1, 2000);

        ResponseDto responseDto = new ResponseDto();
        plantService.save(plantDto);
        responseDto.setContent(plantDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        plantService.delete(id);
        return responseDto;
    }

}

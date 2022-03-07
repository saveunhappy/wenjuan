package com.course.business.controller.web;

import com.course.server.dto.PageDto;
import com.course.server.dto.PlantDto;
import com.course.server.dto.PlantPageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.enums.PlantStatusEnum;
import com.course.server.service.PlantService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("webPlantController")
@RequestMapping("/web/plant")
public class PlantController {
    public static final String BUSINESS_NAME = "用户";
    @Resource
    private PlantService plantService;
    @PostMapping("/list")
    public ResponseDto plant(@RequestBody PlantPageDto plantPageDto){
        ResponseDto responseDto = new ResponseDto();
        plantPageDto.setStatus(PlantStatusEnum.NO.getCode());
        plantService.list(plantPageDto);
        responseDto.setContent(plantPageDto);
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
    @GetMapping("/list-new")
    public ResponseDto listNew(){
        PageDto pageDto = new PageDto();
        pageDto.setPage(1);
        pageDto.setSize(3);
        ResponseDto responseDto = new ResponseDto();

        plantService.listNew(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    
    @GetMapping("/find/{id}")
    public ResponseDto findCourse(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        PlantDto plant = plantService.findPlant(id);
        responseDto.setContent(plant);
        return responseDto;
    }


}

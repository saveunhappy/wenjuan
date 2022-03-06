package com.course.business.controller.web;

import com.course.server.dto.MemberPlantDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.PlantDto;
import com.course.server.dto.ResponseDto;
import com.course.server.enums.PlantStatusEnum;
import com.course.server.service.MemberPlantService;
import com.course.server.service.PlantService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("webMemberPlantController")
@RequestMapping("/web/memberPlant")
public class MemberPlantController {
    public static final String BUSINESS_NAME = "会员领取植物";
    @Resource
    private MemberPlantService memberPlantService;
    @Resource
    private PlantService plantService;
    @PostMapping("/list")
    public ResponseDto memberPlant(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        memberPlantService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/adopt")
    public ResponseDto adopt(@RequestBody MemberPlantDto memberPlantDto){
        // 保存校验
        ValidatorUtil.require(memberPlantDto.getMemberId(), "会员id");
        ValidatorUtil.require(memberPlantDto.getPlantId(), "绿植id");

        ResponseDto responseDto = new ResponseDto();
        MemberPlantDto adopt = memberPlantService.adopt(memberPlantDto);
        PlantDto plant = plantService.findPlant(memberPlantDto.getPlantId());
        plant.setStatus(PlantStatusEnum.YES.getCode());
        plantService.save(plant);

        responseDto.setContent(adopt);
        return responseDto;
    }

    @PostMapping("get-enroll")
    public ResponseDto getEnroll(@RequestBody MemberPlantDto memberPlantDto){
        ResponseDto responseDto = new ResponseDto();

        MemberPlantDto enroll = memberPlantService.getEnroll(memberPlantDto);
        responseDto.setContent(enroll);
        return responseDto;
    }

}

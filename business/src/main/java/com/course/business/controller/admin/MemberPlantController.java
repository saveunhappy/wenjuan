package com.course.business.controller.admin;

import com.course.server.dto.MemberPlantDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.MemberPlantService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/memberPlant")
public class MemberPlantController {
    public static final String BUSINESS_NAME = "会员领取植物";
    @Resource
    private MemberPlantService memberPlantService;
    @PostMapping("/list")
    public ResponseDto memberPlant(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        memberPlantService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody MemberPlantDto memberPlantDto){
        // 保存校验
        ValidatorUtil.require(memberPlantDto.getMemberId(), "会员id");
        ValidatorUtil.require(memberPlantDto.getPlantId(), "绿植id");
        ValidatorUtil.require(memberPlantDto.getAt(), "报名时间");

        ResponseDto responseDto = new ResponseDto();
        memberPlantService.save(memberPlantDto);
        responseDto.setContent(memberPlantDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        memberPlantService.delete(id);
        return responseDto;
    }

    @PostMapping("/adopt")
    public ResponseDto adopt(@RequestBody MemberPlantDto memberPlantDto){
        // 保存校验
        ValidatorUtil.require(memberPlantDto.getMemberId(), "会员id");
        ValidatorUtil.require(memberPlantDto.getPlantId(), "绿植id");

        ResponseDto responseDto = new ResponseDto();
        MemberPlantDto adopt = memberPlantService.adopt(memberPlantDto);
        responseDto.setContent(adopt);
        return responseDto;
    }

}

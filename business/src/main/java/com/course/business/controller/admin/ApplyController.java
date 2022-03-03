package com.course.business.controller.admin;

import com.course.server.dto.ApplyDto;
import com.course.server.dto.ApplyPageDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.ApplyService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/apply")
public class ApplyController {
    public static final String BUSINESS_NAME = "";
    @Resource
    private ApplyService applyService;
    @PostMapping("/list")
    public ResponseDto apply(@RequestBody ApplyPageDto applyPageDto){
        ResponseDto responseDto = new ResponseDto();
        applyService.list(applyPageDto);
        responseDto.setContent(applyPageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ApplyDto applyDto){
        // 保存校验
        ValidatorUtil.length(applyDto.getName(), "昵称", 1, 50);
        ValidatorUtil.require(applyDto.getPlantName(), "绿植名称");
        ValidatorUtil.length(applyDto.getPlantName(), "绿植名称", 1, 50);
        ValidatorUtil.length(applyDto.getUserAddress(), "家庭住址", 1, 50);
        ValidatorUtil.length(applyDto.getUserTelephone(), "用户手机号", 1, 50);
        ValidatorUtil.require(applyDto.getUserId(), "用户id");
        ValidatorUtil.require(applyDto.getPlantId(), "绿植id");

        ResponseDto responseDto = new ResponseDto();
        applyService.save(applyDto);
        responseDto.setContent(applyDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        applyService.delete(id);
        return responseDto;
    }

}

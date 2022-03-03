package com.course.business.controller.admin;

import com.course.server.dto.UserLogDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.dto.UserLogPageDto;
import com.course.server.service.UserLogService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/userLog")
public class UserLogController {
    public static final String BUSINESS_NAME = "申请领养";
    @Resource
    private UserLogService userLogService;
    @PostMapping("/list")
    public ResponseDto userLog(@RequestBody UserLogPageDto userLogPageDto){
        ResponseDto responseDto = new ResponseDto();
        userLogService.list(userLogPageDto);
        responseDto.setContent(userLogPageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody UserLogDto userLogDto){
        // 保存校验
        ValidatorUtil.length(userLogDto.getName(), "昵称", 1, 50);
        ValidatorUtil.require(userLogDto.getPlantId(), "绿植id");
        ValidatorUtil.length(userLogDto.getPlantId(), "绿植id", 1, 50);
        ValidatorUtil.require(userLogDto.getPlantName(), "绿植名称");
        ValidatorUtil.length(userLogDto.getPlantName(), "绿植名称", 1, 50);
        ValidatorUtil.length(userLogDto.getUserAddress(), "家庭住址", 1, 50);
        ValidatorUtil.length(userLogDto.getUserTelephone(), "用户手机号", 1, 50);
        ValidatorUtil.require(userLogDto.getUserId(), "用户id");

        ResponseDto responseDto = new ResponseDto();
        userLogService.save(userLogDto);
        responseDto.setContent(userLogDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        userLogService.delete(id);
        return responseDto;
    }

}

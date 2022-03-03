package com.course.business.controller.admin;

import com.course.server.dto.MemberDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.MemberService;
import com.course.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/member")
public class MemberController {
    public static final String BUSINESS_NAME = "用户";
    @Resource
    private MemberService memberService;
    @PostMapping("/list")
    public ResponseDto member(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        memberService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody MemberDto memberDto){
        // 保存校验
        ValidatorUtil.require(memberDto.getLoginName(), "登录名");
        ValidatorUtil.length(memberDto.getLoginName(), "登录名", 1, 50);
        ValidatorUtil.length(memberDto.getName(), "昵称", 1, 50);
        ValidatorUtil.require(memberDto.getPassword(), "密码");
        ValidatorUtil.length(memberDto.getAddress(), "家庭住址", 1, 50);
        ValidatorUtil.length(memberDto.getTelphone(), "手机号", 1, 2000);

        ResponseDto responseDto = new ResponseDto();
        memberService.save(memberDto);
        responseDto.setContent(memberDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        memberService.delete(id);
        return responseDto;
    }

}

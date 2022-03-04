package com.course.business.controller.web;

import com.alibaba.fastjson.JSON;
import com.course.server.dto.MemberDto;
import com.course.server.dto.ResponseDto;
import com.course.server.exception.BusinessException;
import com.course.server.service.MemberService;
import com.course.server.util.UuidUtil;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController("webMemberController")
@RequestMapping("/web/member")
public class MemberController {

    private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
    public static final String BUSINESS_NAME = "会员";

    @Resource
    private MemberService memberService;

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/register")
    public ResponseDto register(@RequestBody MemberDto memberDto) {
        // 保存校验
        // 保存校验
        ValidatorUtil.require(memberDto.getLoginName(), "登录名");
        ValidatorUtil.length(memberDto.getLoginName(), "登录名", 1, 50);
        ValidatorUtil.length(memberDto.getName(), "昵称", 1, 50);
        ValidatorUtil.require(memberDto.getPassword(), "密码");

        ResponseDto responseDto = new ResponseDto();
        memberService.save(memberDto);
        responseDto.setContent(memberDto);
        return responseDto;
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public ResponseDto login(@RequestBody MemberDto memberDto) {
        LOG.info("用户登录开始");
        ResponseDto responseDto = new ResponseDto();
//
        MemberDto loginMemberDto = memberService.login(memberDto);
//        String token = UuidUtil.getShortUuid();
//        loginMemberDto.setToken(token);
//        redisTemplate.opsForValue().set(token, JSON.toJSONString(loginMemberDto), 3600, TimeUnit.SECONDS);
        responseDto.setContent(loginMemberDto);
        return responseDto;
    }



    @PostMapping("/reset-password")
    public ResponseDto resetPassword(@RequestBody MemberDto memberDto) throws BusinessException {
        LOG.info("会员密码重置开始:");
        ResponseDto<MemberDto> responseDto = new ResponseDto();
//
//        // 校验短信验证码
//        SmsDto smsDto = new SmsDto();
//        smsDto.setMobile(memberDto.getMobile());
//        smsDto.setCode(memberDto.getSmsCode());
//        smsDto.setUse(SmsUseEnum.FORGET.getCode());
//        smsService.validCode(smsDto);
//        LOG.info("短信验证码校验通过");

        // 重置密码
        memberService.resetPassword(memberDto);

        return responseDto;
    }
}

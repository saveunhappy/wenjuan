package com.course.server.service;

import com.course.server.domain.Member;
import com.course.server.domain.MemberExample;
import com.course.server.domain.User;
import com.course.server.domain.UserExample;
import com.course.server.dto.MemberDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.UserDto;
import com.course.server.exception.BusinessException;
import com.course.server.exception.BusinessExceptionCode;
import com.course.server.mapper.MemberMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class MemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    @Resource
    private MemberMapper memberMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        MemberExample memberExample = new MemberExample();
        List<Member> memberList = memberMapper.selectByExample(memberExample);
        PageInfo pageInfo = new PageInfo(memberList);
        pageDto.setTotal(pageInfo.getTotal());

        List<MemberDto> memberDtoList = CopyUtil.copyList(memberList, MemberDto.class);
        pageDto.setList(memberDtoList);
    }

    public void save(MemberDto memberDto){
        Member member = CopyUtil.copy(memberDto, Member.class);

        if(StringUtils.isEmpty(memberDto.getId())){
            this.insert(member);
        }else{
            this.update(member);
        }
    }

    private void update(Member member){
        memberMapper.updateByPrimaryKey(member);
    }

    private void insert(Member member) {
        member.setId(UuidUtil.getShortUuid());

        Member memberDb = this.selectByLoginName(member.getLoginName());
        if (memberDb != null) {
            throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
        }
        memberMapper.insert(member);
    }


    public void delete(String id) {
        memberMapper.deleteByPrimaryKey(id);
    }

    public MemberDto login(MemberDto memberDto){
        Member member = selectByLoginName(memberDto.getLoginName());
        if(member == null){
            logger.info("用户名不存在{}",memberDto.getLoginName());
            throw new BusinessException(BusinessExceptionCode.LOGIN_MEMBER_ERROR);
        } else {
            if (member.getPassword().equals(memberDto.getPassword())) {
                // 登录成功
                MemberDto loginMemberDto = CopyUtil.copy(member, MemberDto.class);
                return loginMemberDto;
            } else {
                logger.info("密码不对, 输入密码：{}, 数据库密码：{}", memberDto.getPassword(), member.getPassword());
                throw new BusinessException(BusinessExceptionCode.LOGIN_MEMBER_ERROR);
            }
        }

    }

    public Member selectByLoginName(String loginName) {
        if (StringUtils.isEmpty(loginName)) {
            return null;
        }
        MemberExample example = new MemberExample();
        example.createCriteria().andLoginNameEqualTo(loginName);
        List<Member> memberList = memberMapper.selectByExample(example);
        if (memberList == null || memberList.size() == 0) {
            return null;
        } else {
            return memberList.get(0);
        }

    }
}

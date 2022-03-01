package com.course.server.service;

import com.course.server.domain.Member;
import com.course.server.domain.MemberExample;
import com.course.server.dto.MemberDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.MemberMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class MemberService {
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

    private void insert(Member member){
        member.setId(UuidUtil.getShortUuid());
        memberMapper.insert(member);
    }
    private void update(Member member){
        memberMapper.updateByPrimaryKey(member);
    }

    public void delete(String id) {
        memberMapper.deleteByPrimaryKey(id);
    }
}

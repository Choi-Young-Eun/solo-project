package com.codestates.soloproject.api.v1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    public void createMember(Member member){
        memberRepository.save(member);
    }
    public List<Member> findAllMembers(){
        List<Member> members = memberRepository.findAll();
        return members;
    }

    public List<Member> findTypeMembers(Long type){
        List<Member> members = memberRepository.findAllByCompanyType(type);
        return members;
    }
}

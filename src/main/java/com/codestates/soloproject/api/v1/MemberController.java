package com.codestates.soloproject.api.v1;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    @PostMapping
    public ResponseEntity postMember(@RequestBody Member member){
        memberService.createMember(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getMembers(){
        List<Member> members = memberService.findAllMembers();
        //Entity -> Dto 로 안바꿈
        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    @GetMapping("/{company-type}")
    public ResponseEntity getTypeMembers(@PathVariable("company-type") Long type){
        List<Member> members = memberService.findTypeMembers(type);
        //Entity -> Dto 로 안바꿈
        return new ResponseEntity<>(members,HttpStatus.OK);
    }
}

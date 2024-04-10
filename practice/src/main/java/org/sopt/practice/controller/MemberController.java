package org.sopt.practice.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.practice.service.MemberService;
import org.sopt.practice.service.dto.MemberCreateDto;
import org.sopt.practice.service.dto.MemberFindDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member") // version 1 api를 만들어 둠(project에서 version 관리할 때 이런식으로 사용)
public class MemberController {

    private final MemberService memberService; // memberServcie를 bin으로 등록하지 않으면 error

    @PostMapping
//    @RequestMapping(method = ) - PostMapping이 더 나중에 나온 거라서 이걸 위주로 사용한다고 함.
    public ResponseEntity createMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate)))
                .build();
    }

    @GetMapping("/{memberId}") //어떤 정보를 가져올건지를 명시해줘야하기 때문에 memberId값을 path parameter로 받음
//    public ResponseEntity<MemberFindDto> getMemberById(
//            @PathVariable Long memberId
//    ) {
//        return ResponseEntity.ok(memberService.findMemberById(memberId));
//    } //데이터가 함께 가야하기 때문에 create가 아니라 200이 떠야함
    public ResponseEntity<MemberFindDto> getMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.getMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(@PathVariable Long memberId){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
}

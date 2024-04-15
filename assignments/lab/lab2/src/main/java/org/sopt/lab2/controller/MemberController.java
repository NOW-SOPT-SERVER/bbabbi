package org.sopt.lab2.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.lab2.domain.Member;
import org.sopt.lab2.service.MemberService;
import org.sopt.lab2.service.dto.MemberCreateDto;
import org.sopt.lab2.service.dto.MemberFindDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity postMember(
            @RequestBody MemberCreateDto memberCreate
    ){
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> getMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.getMemberById(memberId));
    }

    // 등록된 모든 멤버를 List로 Get
    @GetMapping("/allmember")
    public ResponseEntity<List<MemberFindDto>> getAllMembers(){
        List<MemberFindDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(
            @PathVariable Long memberId
    ){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}

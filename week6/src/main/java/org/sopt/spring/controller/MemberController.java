package org.sopt.spring.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.spring.auth.redis.Service.TokenService;
import org.sopt.spring.service.MemberService;
import org.sopt.spring.service.dto.MemberCreateDto;
import org.sopt.spring.service.dto.MemberFindDto;
import org.sopt.spring.service.dto.TokenResponse;
import org.sopt.spring.service.dto.UserJoinResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<UserJoinResponse> postMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> login(
            @RequestHeader("refreshToken") String refreshToken
    ) {
        Long userId = tokenService.findIdByRefreshToken(refreshToken);  // Refresh Token으로부터 userId 추출
        String accessToken = tokenService.generateAccessToken(userId);  // 새로운 Access Token 발급
        return ResponseEntity.ok(new TokenResponse(accessToken));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(@PathVariable Long memberId){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

}

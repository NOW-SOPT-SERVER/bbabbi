package org.sopt.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.spring.common.dto.SuccessMessage;
import org.sopt.spring.common.dto.SuccessStatusResponse;
import org.sopt.spring.service.MemberService;
import org.sopt.spring.service.PostService;
import org.sopt.spring.service.dto.PostCreateRequest;
import org.sopt.spring.service.dto.PostFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final MemberService memberService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location",
                        postService.create(blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<SuccessStatusResponse<PostFindDto>> findPostById(@PathVariable Long postId){
        PostFindDto postFindDto = postService.findById(postId);
        return ResponseEntity.ok(
                SuccessStatusResponse.of(SuccessMessage.POST_FIND_SUCCESS, postFindDto)
        );
    }

}

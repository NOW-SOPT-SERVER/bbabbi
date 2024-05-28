package org.sopt.spring.controller;

import com.sun.net.httpserver.Authenticator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.spring.common.dto.SuccessMessage;
import org.sopt.spring.common.dto.SuccessStatusResponse;
import org.sopt.spring.service.PostService;
import org.sopt.spring.service.dto.PostCreateRequest;
import org.sopt.spring.service.dto.PostFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
//            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location", postService.create(blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    // 전체 게시글
    @GetMapping("/post")
    public ResponseEntity<List<PostFindDto>> getAllPosts(){
        List<PostFindDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // 특정 게시글
    @GetMapping("/post/{postId}")
    public ResponseEntity<SuccessStatusResponse<PostFindDto>> findPostById(@PathVariable Long postId) {
        return ResponseEntity.ok()
                .body(SuccessStatusResponse.of(SuccessMessage.POST_FIND_SUCCESS,
                        postService.findPostById(postId)));
    }

}

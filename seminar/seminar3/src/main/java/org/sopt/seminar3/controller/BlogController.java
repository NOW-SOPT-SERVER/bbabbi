package org.sopt.seminar3.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.common.dto.SuccessMessage;
import org.sopt.seminar3.common.dto.SuccessStatusResponse;
import org.sopt.seminar3.service.BlogService;
import org.sopt.seminar3.service.dto.BlogCreateRequest;
import org.sopt.seminar3.service.dto.BlogTitleUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader /*(name = "memberId")*/ Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest) {
            return ResponseEntity.status(HttpStatus.CREATED).header(
                            "Location",
                            blogService.create(memberId, blogCreateRequest))
                    .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUdpateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUdpateRequest);
        return ResponseEntity.noContent().build();
    }
}

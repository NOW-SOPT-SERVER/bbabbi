package org.sopt.spring.service.dto;

import org.sopt.spring.domain.Blog;
import org.sopt.spring.domain.Post;

public record PostFindDto (
        String title,
        String content,
        Long id
){
    public static PostFindDto of(Post post) {
        return new PostFindDto(post.getTitle(), post.getContent(), post.getId());
    }
}

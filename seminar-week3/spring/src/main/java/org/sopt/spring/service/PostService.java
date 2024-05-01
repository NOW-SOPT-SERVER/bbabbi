package org.sopt.spring.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.spring.common.dto.ErrorMessage;
import org.sopt.spring.domain.Blog;
import org.sopt.spring.domain.Member;
import org.sopt.spring.domain.Post;
import org.sopt.spring.exception.NotFoundException;
import org.sopt.spring.repository.PostRepository;
import org.sopt.spring.service.dto.MemberFindDto;
import org.sopt.spring.service.dto.PostCreateRequest;
import org.sopt.spring.service.dto.PostFindDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BlogService blogService;
    private final MemberService memberService;

    public String create(Long blogId, PostCreateRequest postCreateRequest){
        Blog blog = blogService.findById(blogId);
        Post post = postRepository.save(Post.create(blog, postCreateRequest));
        return post.getId().toString();
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        );
    }

    public PostFindDto findPostById(Long postId) {
        return PostFindDto.of(postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        ));
    }

}

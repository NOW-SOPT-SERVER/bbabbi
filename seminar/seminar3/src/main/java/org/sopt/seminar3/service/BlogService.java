package org.sopt.seminar3.service;

import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.Member;
import org.sopt.seminar3.repository.BlogRepository;
import org.sopt.seminar3.service.dto.BlogCreateRequest;
import org.sopt.seminar3.service.dto.BlogTitleUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String create(
            Long memberId,
            BlogCreateRequest createRequest
    ) {
        //member찾기
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, createRequest));
        return blog.getId().toString();
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findBlogById(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }
}

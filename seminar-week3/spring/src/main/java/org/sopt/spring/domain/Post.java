package org.sopt.spring.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.spring.service.dto.PostCreateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    @Builder
    private Post(String title, String content, Blog blog){
        this.title = title;
        this.content = content;
        this.blog = blog;
    }

    public static Post create(Blog blog, PostCreateRequest postCreateRequest) {
        return new Post(postCreateRequest.title(), postCreateRequest.content(), blog);
    }
}

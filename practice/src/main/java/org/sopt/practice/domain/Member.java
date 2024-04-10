package org.sopt.practice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // DB 구조에 따라 맡기겠다는 것
    private Long id; // toString()을 사용하려면 원시타입인 long이 아닌 참조 타입인 Long으로 선언해줘야 함.

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private int age;

    @Builder // -> 아래의 인자들을 가지고 있는 Builder Class가 만들어짐
    // 생성자(객체의 무분별한 생성을 막기 위해 private로 설정)
    private Member(String name, Part part, int age){
        this.name = name;
        this.part = part;
        this.age = age;
    }

    // 정적 factory 메서드 by Buidler
    public static Member create(String name, Part part, int age){
        return Member.builder()
                .name(name)
                .age(age)
                .part(part)
                .build();
    }
}

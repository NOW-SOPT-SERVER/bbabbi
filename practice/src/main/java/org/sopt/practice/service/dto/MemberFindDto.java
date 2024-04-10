package org.sopt.practice.service.dto;

import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) { //객체 자체를 받아오는 거니까 생성하는 걸 넣어줘야함
    public static MemberFindDto of(Member member){
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}

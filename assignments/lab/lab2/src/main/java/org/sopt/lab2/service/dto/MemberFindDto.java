package org.sopt.lab2.service.dto;

import org.sopt.lab2.domain.Member;
import org.sopt.lab2.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {
    public static MemberFindDto of(
            Member member
    ){
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}

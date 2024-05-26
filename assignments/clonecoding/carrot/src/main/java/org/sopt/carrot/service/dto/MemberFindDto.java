package org.sopt.carrot.service.dto;

import org.sopt.carrot.domain.Member;
import org.sopt.carrot.domain.Part;

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

package org.sopt.carrot.service.dto;

import org.sopt.carrot.domain.Part;

public record MemberCreateDto (
        String name,
        Part part,
        int age
) {
}

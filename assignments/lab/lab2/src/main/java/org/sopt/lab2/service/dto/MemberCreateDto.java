package org.sopt.lab2.service.dto;

import org.sopt.lab2.domain.Part;

public record MemberCreateDto (
        String name,
        Part part,
        int age
) {
}

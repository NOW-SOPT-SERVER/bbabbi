package org.sopt.practice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 생성자를 만들 수 있는 annotation
@Getter // ⭐️
public class ApiResponse {
    private String content;

    public static ApiResponse create(String content){
        return new ApiResponse(content);
    }

}

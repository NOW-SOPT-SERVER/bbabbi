package org.sopt.carrot.service.dto;

public record ProductCreateDto (
        String title,
        int price,
        String note,
        String spot
){
}

package org.sopt.seminar3.common.dto;

public record ErrorResponse (
        int status,
        String message
){
    public static ErrorResponse of(int status, String message){
        return new ErrorResponse(status, message);
    }
}

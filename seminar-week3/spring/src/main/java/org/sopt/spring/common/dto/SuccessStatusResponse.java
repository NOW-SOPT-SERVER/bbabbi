package org.sopt.spring.common.dto;

public record SuccessStatusResponse<T>(
        int status,
        String message,
        T data
) {

    // 데이터 미포함
    public static <T> SuccessStatusResponse<T> of(SuccessMessage successMessage) {
        return new SuccessStatusResponse<T>(successMessage.getStatus(), successMessage.getMessage(), null);
    }

    // 데이터 포함
    public static <T> SuccessStatusResponse<T> of(SuccessMessage successMessage, T data) {
        return new SuccessStatusResponse<T>(successMessage.getStatus(), successMessage.getMessage(), data);
    }

}

package com.hackaton.bbva.model.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class BaseResponse<T> {
    private final Integer status;
    private final String error;
    private final String message;
    private final T data;

    public static BaseResponse successNoData() {
        return BaseResponse.builder()
                .status(HttpStatus.OK.value())
                .build();
    }

    public static <T> BaseResponse<T> successWithData(T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.OK.value())
                .data(data)
                .build();
    }

    public static BaseResponse error(Integer status) {
        return BaseResponse.builder()
                .status(status)
                .build();
    }
}
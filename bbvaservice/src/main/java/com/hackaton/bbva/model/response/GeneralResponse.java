package com.hackaton.bbva.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GeneralResponse<T> {
    private Integer status = HttpStatus.OK.value();
    private String error;
    private String message;
    private T data;
}

package com.hackaton.bbva.handler;

import com.hackaton.bbva.model.response.ExceptionResponse;
import com.hackaton.bbva.util.GlobalUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        ex.getMessage(),
                        GlobalUtil.stackTraceToString(ex)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.NOT_FOUND.value(),
                        ex.getMessage(),
                        GlobalUtil.stackTraceToString(ex)),
                HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(),
                        ex.getBindingResult().getAllErrors().get(1).getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
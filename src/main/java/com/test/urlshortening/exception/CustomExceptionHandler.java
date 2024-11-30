package com.test.urlshortening.exception;

import com.test.urlshortening.util.ResponseModelFailed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ResponseModelFailed> handleValidationExceptions(
            MethodArgumentNotValidException ex, ServletWebRequest request)
    {
        LOGGER.error("400 Status Code : {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ResponseModelFailed responseModelFailed = new ResponseModelFailed(HttpStatus.BAD_REQUEST, errors, request.getRequest().getRequestURI());
        return new ResponseEntity<>(responseModelFailed, HttpStatus.BAD_REQUEST);
    }
}

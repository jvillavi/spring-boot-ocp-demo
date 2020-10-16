package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ ItemNotFoundException.class })
    public ResponseEntity<Object> handleEntityNotFoundException(ItemNotFoundException ex, WebRequest request) {
        HashMap<String, Object> errorMap = new HashMap<>();
        errorMap.put("id", ex.getId());
        errorMap.put("message",ex.getMessage());
        return new ResponseEntity<Object>(errorMap, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}

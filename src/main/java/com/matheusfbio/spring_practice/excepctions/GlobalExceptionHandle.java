package com.matheusfbio.spring_practice.excepctions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> handleResourceNotFound( ResourceNotFound e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("time", LocalDateTime.now());
        body.put("message", e.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Resource Not Found");  
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);  
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericExcepetion( Exception e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("time", LocalDateTime.now());
        body.put("message", e.getMessage());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Resource Not Found");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);  
    }
}
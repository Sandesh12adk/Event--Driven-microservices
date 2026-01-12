package com.example.WRKEL.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handler(Exception ex){
        Map<String, String> error= new HashMap<>();
        error.put("Causer", ex.getCause().toString());
        error.put("Message",ex.getMessage());
        error.put("Class",ex.getClass().getName());
        error.put("Detail", ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

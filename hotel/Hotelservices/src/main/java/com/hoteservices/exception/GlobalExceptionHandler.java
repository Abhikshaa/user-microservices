package com.hoteservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException e) {
   Map  map = new HashMap();
   map.put("message",e.getMessage());
   map.put("Success",false);
   map.put("Status", HttpStatus.NOT_FOUND);
   return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);

     }
}
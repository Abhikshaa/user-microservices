package com.userservices.exception;

import com.userservices.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //Centralized Exception handler of whole project
public class GlobalExceptionHandler {
     @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception){

          String message = exception.getMessage();
          ApiResponse build = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
     return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);
     }


}

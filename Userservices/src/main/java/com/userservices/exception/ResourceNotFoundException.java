package com.userservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{

     public ResourceNotFoundException(){
          super("Resource Not found on server!!");
     }
     public ResourceNotFoundException(String message){
          super(message);
     }
}

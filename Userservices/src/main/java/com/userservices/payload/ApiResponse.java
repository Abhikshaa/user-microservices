package com.userservices.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder//build the object of this class
public class ApiResponse {

     private String message;
     private boolean success;
     private HttpStatus status;
}

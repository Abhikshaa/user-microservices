package com.userservices.controller.user;

import com.userservices.entity.User;
import com.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
     @Autowired
     private UserService userService;
     @PostMapping
     public ResponseEntity<User> createUser(@RequestBody User user){

          User saved = userService.saveUser(user);

          return new ResponseEntity<>(saved, HttpStatus.CREATED);
     }
     @GetMapping("/users/{userId}")
     public ResponseEntity<User> getById(@PathVariable("userId") String userId){

          User user = userService.getUser(userId);

          return new ResponseEntity<>(user,HttpStatus.OK);
     }
     @GetMapping
     public List<User> getAllUser(){
       return   userService.getAllUser();
     }
}

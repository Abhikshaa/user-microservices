package com.user.controller;

import com.user.entity.User;
import com.user.payload.UserDTO;
import com.user.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
     private UserRepository userRepository;

     public UserController(UserRepository userRepository) {
          this.userRepository = userRepository;
     }
     @PostMapping
     public void saveUser(@RequestBody User user){
          userRepository.save(user);
     }
     @PutMapping
     public void UpdateUser(@RequestBody User user){
          userRepository.save(user);
     }
     @GetMapping
     List<User> getAll(){
          List<User> list = userRepository.findAll();
          return list;
     }
     @DeleteMapping("/{id}")
     public void  userDelete(@PathVariable("id") long id){

       userRepository.deleteById(id);     }
     @GetMapping("/{id}")
      User getById(@PathVariable("id") long id) {
           Optional<User> user = userRepository.findById(id);

           return user.get();
      }
}

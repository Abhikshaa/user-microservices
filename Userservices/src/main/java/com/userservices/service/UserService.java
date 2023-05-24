package com.userservices.service;

import com.userservices.entity.User;

import java.util.List;

public interface UserService {

     User saveUser(User user);
     List<User> getAllUser();

     User getUser(String userId);

}

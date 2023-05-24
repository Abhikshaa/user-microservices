package com.userservices.service.impl;

import com.userservices.REPOSITORY.UserRepository;
import com.userservices.entity.Hotel;
import com.userservices.entity.Rating;
import com.userservices.entity.User;
import com.userservices.exception.ResourceNotFoundException;
import com.userservices.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
     private UserRepository userRepository;
     @Autowired
     private RestTemplate restTemplate;
       private org.slf4j.Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
     @Override
     public User saveUser(User user) {
          //generate unique userId
          String randomId = UUID.randomUUID().toString();
          user.setUserId(randomId);
          return userRepository.save(user);
     }

     @Override
     public List<User> getAllUser() {
          return userRepository.findAll();
     }

     @Override
     public User getUser(String userId) {
          //get user from database with help of repository
          User user = userRepository.findById(userId).orElseThrow(() -> new

                  ResourceNotFoundException("User with given  id is not found on server!!:" + userId));
          //fetch rating of the above user from Rating_service
          //http://localhost:8083/ratings/834b107c-de58-49fd-b865-d21175d36db5
          Rating[] ratingsofuser = restTemplate.getForObject
                  ("http://localhost:8083/ratings/"+user.getUserId(), Rating[].class);
          logger.info("{}",ratingsofuser);


          List<Rating> ratings = Arrays.stream(ratingsofuser).collect(Collectors.toList());

          ;
          List<Rating> ratingList = ratings.stream().map(rating -> {
               System.out.println(rating.getHotelId());
               ResponseEntity<Hotel> forEntity = restTemplate.getForEntity
                       ("http://localhost:8082/hotels/"+rating.getRatingId(), Hotel.class);
               Hotel hotel = forEntity.getBody();

               logger.info("Response status code:{}",forEntity.getStatusCode());
                    rating.setHotel(hotel);

               return rating;
          }).collect(Collectors.toList());
          //http://localhost:8083/ratings/03e9a2cb-666e-4b23-ab32-b9c19e61a41b
          user.setRatings(ratingList);
          return user;            //
          //api call to hotel service
          //set the hotel to rating
          //return the rating
     }
}

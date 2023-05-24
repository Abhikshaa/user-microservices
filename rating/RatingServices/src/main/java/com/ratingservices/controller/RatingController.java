package com.ratingservices.controller;

import com.ratingservices.entity.Rating;
import com.ratingservices.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
     @Autowired
     private RatingService ratingService;

     @PostMapping
     public ResponseEntity<Rating> create(@RequestBody Rating rating){

          Rating rate = ratingService.create(rating);
          return new ResponseEntity<>(rate, HttpStatus.CREATED);
     }
     @GetMapping
     public ResponseEntity<List<Rating>> getRating(){
          return ResponseEntity.ok(ratingService.getAllRating());
     }
     @GetMapping("/hotels/{hotelId}")
     public ResponseEntity<List<Rating>> getByHotel(@PathVariable("hotelId") String hotelId){
          List<Rating> list = ratingService.getById(hotelId);
          return new ResponseEntity<>(list,HttpStatus.OK);
     }
     @GetMapping("/{userId}")
     public ResponseEntity<List<Rating>> getByUser(@PathVariable("userId") String userId){
          List<Rating> list = ratingService.getRatingByUser(userId);
          return new ResponseEntity<>(list,HttpStatus.OK);
     }
}

package com.ratingservices.service;

import com.ratingservices.entity.Rating;

import java.util.List;

public interface RatingService {

     Rating create(Rating rating);

    List<Rating> getAllRating();
    List<Rating> getRatingByUser(String userId);
     List<Rating> getById(String hotelId);


}

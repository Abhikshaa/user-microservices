package com.ratingservices.service.impl;

import com.ratingservices.entity.Rating;
import com.ratingservices.repository.RatingRepository;
import com.ratingservices.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
     @Autowired
     private RatingRepository ratingRepository;

     @Override
     public Rating create(Rating rating) {
          String ratingId = UUID.randomUUID().toString();
          rating.setRatingId(ratingId);
          return ratingRepository.save(rating);
     }

     @Override
     public List<Rating> getAllRating() {
          return ratingRepository.findAll();
     }

     @Override
     public List<Rating> getRatingByUser(String userId) {
          return ratingRepository.findByUserId(userId);
     }

     @Override
     public List<Rating> getById(String hotelId) {
          return ratingRepository.findByHotelId(hotelId);
     }


}

package com.hoteservices.service.impl;

import com.hoteservices.entity.Hotel;
import com.hoteservices.exception.ResourceNotFoundException;
import com.hoteservices.repository.HotelRepository;
import com.hoteservices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
     @Autowired

     private HotelRepository hotelRepository;

     @Override
     public Hotel create(Hotel hotel) {
          String s = UUID.randomUUID().toString();
          hotel.setHotelId(s);
          return hotelRepository.save(hotel);
     }

     @Override
     public List<Hotel> getAllHotel() {
          return hotelRepository.findAll();
     }

     @Override
     public Hotel getByHotelId(String hotelId) {
          return hotelRepository.findById(hotelId).
                  orElseThrow(()-> new ResourceNotFoundException("Hotel not found With"+hotelId));
     }
}

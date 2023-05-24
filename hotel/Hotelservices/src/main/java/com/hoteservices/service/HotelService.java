package com.hoteservices.service;

import com.hoteservices.entity.Hotel;

import java.util.List;

public interface HotelService {

     Hotel create(Hotel hotel);

     List<Hotel> getAllHotel();

     Hotel getByHotelId(String hotelId);
}

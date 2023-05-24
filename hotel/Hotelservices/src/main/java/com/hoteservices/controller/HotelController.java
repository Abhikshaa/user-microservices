package com.hoteservices.controller;

import com.hoteservices.entity.Hotel;
import com.hoteservices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
     @Autowired
     private HotelService hotelService;
     @PostMapping
     public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
          Hotel save = hotelService.create(hotel);
          return new ResponseEntity<>(save, HttpStatus.CREATED);
     }
     @GetMapping
     public List<Hotel> getAllHotel(){
          return hotelService.getAllHotel();
     }
     @GetMapping("/{hotelId}")
     public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId){
          Hotel save = hotelService.getByHotelId(hotelId);
          return new ResponseEntity<>(save, HttpStatus.OK);
     }
}

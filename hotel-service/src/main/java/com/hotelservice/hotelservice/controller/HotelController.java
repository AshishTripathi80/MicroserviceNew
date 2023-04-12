package com.hotelservice.hotelservice.controller;

import com.hotelservice.hotelservice.models.Hotel;
import com.hotelservice.hotelservice.repo.HotelRepository;
import com.hotelservice.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/{city}")
    public List<Hotel> getHotelsByCity(@PathVariable String city) {
        return hotelService.getHotelsByCity(city);
    }






    @PostMapping("/generate")
    public ResponseEntity<String> generateHotels() {
        hotelService.generateAndSaveHotels();
        return ResponseEntity.ok("10 hotels generated and saved.");
    }

}

package com.hotelservice.hotelservice.controller;

import com.hotelservice.hotelservice.models.Hotel;
import com.hotelservice.hotelservice.repo.HotelRepository;
import com.hotelservice.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping("/search")
    public List<Hotel> getHotelsByCity(@RequestParam(value = "city") String city){
        return hotelService.getHotelsByCity(city);
    }

    @GetMapping("/hotelDetail")
    public Hotel getHotelByID(@RequestParam(value = "hotelId") Long hotelId) {
        return hotelRepository.findById(hotelId).orElse(null);
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateHotels() {
        hotelService.generateAndSaveHotels();
        return ResponseEntity.ok("10 hotels generated and saved.");
    }


    @PostConstruct
    public void init() {
        generateHotels();
    }

}

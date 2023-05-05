package com.hotelservice.hotelservice.controller;

import com.hotelservice.hotelservice.models.Hotel;
import com.hotelservice.hotelservice.repo.HotelRepository;
import com.hotelservice.hotelservice.service.HotelService;
import com.hotelservice.hotelservice.utility.GlobalResources;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private Logger logger = GlobalResources.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/search")
    public List<Hotel> getHotelsByCity(@RequestParam(value = "city") String city) {
        String methodName = "getHotelsByCity";
        logger.info(methodName + "Called");
        logger.info("Fetching hotels for city: {}", city);
        List<Hotel> hotels = hotelService.getHotelsByCity(city);
        logger.info("Found {} hotels for city: {}", hotels.size(), city);
        return hotels;
    }

    @GetMapping("/hotelDetail")
    public Hotel getHotelByID(@RequestParam(value = "hotelId") Long hotelId) {
        logger.info("Fetching hotel by ID: {}", hotelId);
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        assert hotel != null;
        logger.info("Found hotel by ID {}: {}", hotelId, hotel.getName());
        return hotel;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateHotels() {
        logger.info("Generating 10 hotels.");
        hotelService.generateAndSaveHotels();
        logger.info("Generated and saved 10 hotels.");
        return ResponseEntity.ok("10 hotels generated and saved.");
    }

    @PostConstruct
    public void init() {
        generateHotels();
    }

}

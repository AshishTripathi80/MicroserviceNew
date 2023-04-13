package com.hotelservice.hotelservice.controller;

import com.hotelservice.hotelservice.models.BookingDetail;
import com.hotelservice.hotelservice.models.Hotel;
import com.hotelservice.hotelservice.repo.HotelRepository;
import com.hotelservice.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/{city}")
    public List<Hotel> getHotelsByCity(@PathVariable String city) {
        return hotelService.getHotelsByCity(city);
    }

    @GetMapping("hotelDetail/{hotelId}")
    public Hotel getHotelByID(@PathVariable Long hotelId) {
        return hotelRepository.findById(hotelId).orElse(null);
    }


    @PostMapping("/booking")
    public void createBooking(@RequestBody BookingDetail booking) throws Exception {

        ResponseEntity<BookingDetail> result = restTemplate.postForEntity("http://localhost:8098/booking/", booking, BookingDetail.class);

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

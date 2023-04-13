package com.flightservice.controller;


import com.flightservice.model.BookingDetail;
import com.flightservice.model.FlightDetail;
import com.flightservice.repository.FlightRepository;
import com.flightservice.service.flightService.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @Autowired
    FlightRepository flightRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public FlightDetail createFlight(@RequestBody FlightDetail flight) throws Exception {

        return this.flightService.createFlight(flight);
    }

    @GetMapping("/{flightId}")
    public FlightDetail getFlightDetail(@PathVariable Long flightId) {
        return this.flightService.getFlightDetail(flightId);
    }

    @GetMapping("/byFromCityAndToCity/{fromCity}/{toCity}")
    public List<FlightDetail> searchFlightByFromCityAndToCity(@PathVariable String fromCity,@PathVariable String toCity) {
        return (List<FlightDetail>) this.flightRepository.searchFlightByFromCityAndToCity(fromCity,toCity);
    }

    @PostMapping("/booking")
    public void createBooking(@RequestBody BookingDetail booking) throws Exception {

        ResponseEntity<BookingDetail> result = restTemplate.postForEntity("http://localhost:8098/booking/", booking, BookingDetail.class);

    }


}

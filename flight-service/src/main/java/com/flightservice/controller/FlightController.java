package com.flightservice.controller;


import com.flightservice.model.FlightDetail;
import com.flightservice.repository.FlightRepository;
import com.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;


    @Autowired
    FlightRepository flightRepository;

    @PostMapping("/")
    public FlightDetail createFlight(@RequestBody FlightDetail flight) {

        return this.flightService.createFlight(flight);
    }

    @GetMapping("/FlightDetail")
    public FlightDetail getFlightDetail(@RequestParam(value = "flightId") Long flightId) {
        return this.flightService.getFlightDetail(flightId);
    }

    @GetMapping("/search")
    public List<FlightDetail> searchFlightByFromCityAndToCity(@RequestParam(value = "fromCity") String fromCity, @RequestParam(value = "toCity") String toCity) {
        return this.flightRepository.searchFlightByFromCityAndToCity(fromCity, toCity);
    }



}

package com.flightservice.controller;


import com.flightservice.model.FlightDetail;
import com.flightservice.repository.FlightRepository;
import com.flightservice.service.FlightService;
import com.flightservice.utility.GlobalResources;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private Logger logger= GlobalResources.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/")
    public FlightDetail createFlight(@RequestBody FlightDetail flight) {
        logger.info("Creating flight with details: {}", flight);
        return this.flightService.createFlight(flight);
    }

    @GetMapping("/FlightDetail")
    public FlightDetail getFlightDetail(@RequestParam(value = "flightId") Long flightId) {
        logger.info("Retrieving flight detail for flight with id {}", flightId);
        return this.flightService.getFlightDetail(flightId);
    }

    @GetMapping("/search")
    public List<FlightDetail> searchFlightByFromCityAndToCity(@RequestParam(value = "fromCity") String fromCity, @RequestParam(value = "toCity") String toCity) {
        logger.info("Searching for flights from {} to {}", fromCity, toCity);
        return this.flightRepository.searchFlightByFromCityAndToCity(fromCity, toCity);
    }
}


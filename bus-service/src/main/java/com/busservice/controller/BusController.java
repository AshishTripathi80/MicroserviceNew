package com.busservice.controller;


import com.busservice.model.BusDetail;
import com.busservice.repository.BusRepository;
import com.busservice.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;


    @Autowired
    BusRepository busRepository;

    @PostMapping("/addBus")
    public BusDetail createBus(@RequestBody BusDetail bus) {
        return this.busService.createBus(bus);
    }

    @GetMapping("/BusDetail")
    public BusDetail getBusDetail(@RequestParam(value = "busId") Long busId) {
        return this.busService.getBusDetail(busId);
    }

    @GetMapping("/search")
    public List<BusDetail> searchFlightByFromCityAndToCity(@RequestParam(value = "fromCity") String fromCity, @RequestParam(value = "toCity") String toCity) {
        return this.busRepository.searchBusByFromCityAndToCity(fromCity, toCity);
    }



}


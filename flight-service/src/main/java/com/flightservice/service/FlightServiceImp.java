package com.flightservice.service;

import com.flightservice.model.FlightDetail;
import com.flightservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImp implements FlightService {

    @Autowired
    private FlightRepository flightRepository;


    @Override
    public FlightDetail createFlight(FlightDetail flight) {
            return this.flightRepository.save(flight);
    }

    @Override
    public FlightDetail getFlightDetail(long flightId) {
        return this.flightRepository.findByFlightId(flightId);
    }


}

package com.flightservice.service;

import com.flightservice.model.FlightDetail;

public interface FlightService {
    FlightDetail createFlight(FlightDetail flight);

    FlightDetail getFlightDetail(long flightId);
}

package com.flightservice.service.flightService;

import com.flightservice.model.FlightDetail;

public interface FlightService {
    public FlightDetail createFlight(FlightDetail flight) throws Exception;

    public FlightDetail getFlightDetail(long FlightId);
}

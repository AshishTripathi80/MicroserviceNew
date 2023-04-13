package com.flightservice.service.flightService;

import com.flightservice.model.FlightDetail;
import com.flightservice.repository.FlightRepository;
import com.flightservice.service.flightService.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImp implements FlightService {

    @Autowired
    private FlightRepository flightRepository;


    @Override
    public FlightDetail createFlight(FlightDetail flight) throws Exception {
        FlightDetail local=this.flightRepository.findByFlightId(flight.getFlightId());
        if(local !=null){
            System.out.println("flightName is already there !!");
            throw new Exception("flightName already present !!");
        }else{
            //user create
            local=this.flightRepository.save(flight);
        }
        return local;
    }

    @Override
    public FlightDetail getFlightDetail(long flightId) {
        return this.flightRepository.findByFlightId(flightId);
    }


}

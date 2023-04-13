package com.flightservice.repository;

import com.flightservice.model.FlightDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository  extends JpaRepository<FlightDetail,Long> {
    FlightDetail findByFlightId(long flightId);

    @Query(value = "select * from FLIGHT_DETAIL where from_City = ?1 and to_City=?2", nativeQuery = true)
    List<FlightDetail> searchFlightByFromCityAndToCity(String fromCity, String toCity);

}



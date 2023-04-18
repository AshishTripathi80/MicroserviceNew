package com.flightservice;

import com.flightservice.model.FlightDetail;
import com.flightservice.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FlightServiceApplicationTests {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	void getBusByCity_shouldReturnHotels() {

		FlightDetail flightDetail = new FlightDetail(null, "flight1","a","b","12-09-2023");
		flightRepository.save(flightDetail);
		List<FlightDetail> bus=flightRepository.searchFlightByFromCityAndToCity("a","b");
		assertEquals("flight1", bus.get(0).getFlightName());
	}

	@Test
	void getBusByCity_shouldReturnEmptyList() {
		FlightDetail flightDetail = new FlightDetail(null, "flight1","a","b","12-09-2023");
		flightRepository.save(flightDetail);
		List<FlightDetail> bus=flightRepository.searchFlightByFromCityAndToCity("a","d");
		assertTrue(bus.isEmpty());
	}



}

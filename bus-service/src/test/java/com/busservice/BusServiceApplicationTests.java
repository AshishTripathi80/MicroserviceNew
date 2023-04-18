package com.busservice;

import com.busservice.model.BusDetail;
import com.busservice.repository.BusRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BusServiceApplicationTests {


	@Autowired
	private BusRepository busRepository;

	@Test
	void getBusByCity_shouldReturnHotels() {

		BusDetail busDetail = new BusDetail(null, "Bus1","gorakhpur","delhi","12-09-2023");
		busRepository.save(busDetail);
		List<BusDetail> bus=busRepository.searchBusByFromCityAndToCity("gorakhpur","delhi");
		assertEquals("Bus1", bus.get(0).getBusName());
	}

	@Test
	void getBusByCity_shouldReturnEmptyList() {
		BusDetail busDetail = new BusDetail(null, "Bus1","gorakhpur","delhi","12-09-2023");
		busRepository.save(busDetail);
		List<BusDetail> bus=busRepository.searchBusByFromCityAndToCity("gorakhpur","lucknow");
		assertTrue(bus.isEmpty());
	}


}

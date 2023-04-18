package com.hotelservice.hotelservice;

import com.hotelservice.hotelservice.models.Hotel;
import com.hotelservice.hotelservice.repo.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HotelServiceApplicationTests {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    void getHotelsByCity_shouldReturnHotels() {

        Hotel hotel1 = new Hotel(null, "Hotel1","12-09-2023","12-09-2023","city1",111.2);
        hotelRepository.save(hotel1);
        List<Hotel> hotel=hotelRepository.findByCity("city1");
        assertEquals("Hotel1", hotel.get(0).getName());
    }

    @Test
    void getHotelsByCity_shouldReturnEmptyList() {
        Hotel hotel1 = new Hotel(null, "Hotel1","12-09-2023","12-09-2023","city1",111.2);
        hotelRepository.save(hotel1);
        List<Hotel> hotel=hotelRepository.findByCity("city2");
        assertTrue(hotel.isEmpty());
    }

    @Test
    void getHotelsById_shouldReturnHotels(){
        Hotel hotel=hotelRepository.findById(1L).orElse(null);
        assertTrue(hotel!=null);
    }


}

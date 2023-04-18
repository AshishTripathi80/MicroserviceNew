package com.hotelservice.hotelservice.service;

import com.hotelservice.hotelservice.models.Hotel;
import com.hotelservice.hotelservice.repo.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotelsByCity(String city) {
        return hotelRepository.findByCityIgnoreCase(city);
    }

    public void generateAndSaveHotels() {
        List<Hotel> hotels = new ArrayList<>();
        Random random = new Random();
        String[] cities = {"Gorakhpur", "Lucknow", "Delhi", "Noida", "Jaipur","Patna"};
        String[] names = {"Hotel A", "Hotel B", "Hotel C", "Hotel D", "Hotel E", "Hotel F", "Hotel G", "Hotel H", "Hotel I", "Hotel J"};
        for (int i = 0; i < 50; i++) {
            hotels.add(new Hotel(null, names[random.nextInt(names.length)], "2023-04-01", "2023-04-05", cities[random.nextInt(cities.length)], random.nextDouble() * 200));
        }
        hotelRepository.saveAll(hotels);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}

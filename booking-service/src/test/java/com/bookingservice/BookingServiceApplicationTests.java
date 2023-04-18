package com.bookingservice;

import com.bookingservice.model.BookingDetail;
import com.bookingservice.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookingServiceApplicationTests {

    @Autowired
    private BookingRepository bookingRepository;


    @Test
    void getHotelsByCity_shouldReturnHotels() {

        BookingDetail bookingDetail = new BookingDetail(null, "ashish12", "indigo", 1L, null, null, null, null);
        bookingRepository.save(bookingDetail);
        List<BookingDetail> booking = bookingRepository.findByUsername("ashish12");
        assertEquals("indigo", booking.get(0).getName());
    }

    @Test
    void getHotelsByCity_shouldReturnEmptyList() {
        BookingDetail bookingDetail = new BookingDetail(null, "ashish12", "indigo", 1L, null, null, null, null);
        bookingRepository.save(bookingDetail);
        List<BookingDetail> booking = bookingRepository.findByUsername("shubham");
        assertTrue(booking.isEmpty());
    }

}

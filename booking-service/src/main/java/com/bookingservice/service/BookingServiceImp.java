package com.bookingservice.service;

import com.bookingservice.model.BookingDetail;
import com.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImp implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingDetail createBooking(BookingDetail booking) {
            //user create
            return this.bookingRepository.save(booking);
    }

    @Override
    public BookingDetail getBookingDetail(Long bookingId) {
        return this.bookingRepository.findByBookingId(bookingId);
    }

    @Override
    public List<BookingDetail> getAllBooking(String username) {
        return this.bookingRepository.findByUsername(username);
    }
}

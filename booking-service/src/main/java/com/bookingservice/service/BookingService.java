package com.bookingservice.service;

import com.bookingservice.model.BookingDetail;

import java.util.List;

public interface BookingService {
    BookingDetail createBooking(BookingDetail booking);

    BookingDetail getBookingDetail(Long bookingId);

    List<BookingDetail> getAllBooking(String username);
}
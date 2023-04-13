package com.bookingservice.service;

import com.bookingservice.model.BookingDetail;

import java.util.List;

public interface BookingService {
    public BookingDetail createBooking(BookingDetail booking) throws Exception;

    public BookingDetail getBookingDetail(Long bookingId);

    public List<BookingDetail> getAllBooking(String username);
}
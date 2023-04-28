package com.bookingservice.controller;

import com.bookingservice.model.BookingDetail;
import com.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/")
    public BookingDetail createBooking(@RequestBody BookingDetail booking) {

        //return this.bookingService.createBooking(booking);
        if (bookingService.isHotelBooked(booking.getHotelId())) {
            throw new IllegalArgumentException("Hotel is already booked");
        }
        if (bookingService.isFlightBooked(booking.getFlightId())) {
            throw new IllegalArgumentException("Hotel is already booked");
        }
        if (bookingService.isBusBooked(booking.getBusId())) {
            throw new IllegalArgumentException("Hotel is already booked");
        }

        // Create the booking
        return this.bookingService.createBooking(booking);
    }

    @GetMapping("/ByBookingId")
    public BookingDetail getBookingDetail(@RequestParam(value = "bookingId") Long bookingId) {
        return this.bookingService.getBookingDetail(bookingId);
    }

    @GetMapping("/byUsername")
    public List<BookingDetail> getAllBooking(@RequestParam(value = "username") String username) {
        return this.bookingService.getAllBooking(username);
    }

}

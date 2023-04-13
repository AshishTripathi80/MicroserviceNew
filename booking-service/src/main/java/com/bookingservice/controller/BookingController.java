package com.bookingservice.controller;

import com.bookingservice.model.BookingDetail;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;


    @PostMapping("/")
    public BookingDetail createBooking(@RequestBody BookingDetail booking) throws Exception {

        return this.bookingService.createBooking(booking);
    }

    @GetMapping("/ByBookingId/{bookingId}")
    public BookingDetail getBookingDetail(@PathVariable Long bookingId) {
        return this.bookingService.getBookingDetail(bookingId);
    }

    @GetMapping("/byUsername/{username}")
    public List<BookingDetail> getAllBooking(@PathVariable String username) {
        return (List<BookingDetail>) this.bookingService.getAllBooking(username);
    }

}

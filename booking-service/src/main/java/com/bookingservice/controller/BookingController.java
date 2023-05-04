package com.bookingservice.controller;

import com.bookingservice.model.BookingDetail;
import com.bookingservice.model.BookingRequest;
import com.bookingservice.model.OTPRequest;
import com.bookingservice.model.PaymentRequest;
import com.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private BookingService bookingService;


    @PostMapping("/")
    public BookingDetail createBooking(@RequestBody BookingRequest bookingRequest) {
        BookingDetail booking = bookingRequest.getBookingDetail();
        PaymentRequest paymentRequest = bookingRequest.getPaymentRequest();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8089/payment/initiate", new HttpEntity<>(paymentRequest, headers), String.class);


        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Failed to initiate payment: " + response.getBody());
        }
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

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOTP(@RequestBody OTPRequest otpRequest, @RequestParam(value = "cardNumber") String cardNumber, @RequestParam(value = "price")Double price) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8089/payment/verify?cardNumber="+cardNumber+"&price="+price, new HttpEntity<>(otpRequest, headers), String.class);
        return response;

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

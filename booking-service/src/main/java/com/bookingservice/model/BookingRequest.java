package com.bookingservice.model;


public class BookingRequest {

    private BookingDetail bookingDetail;

    private PaymentRequest paymentRequest;

    public BookingRequest(BookingDetail bookingDetail, PaymentRequest paymentRequest) {
        this.bookingDetail = bookingDetail;
        this.paymentRequest = paymentRequest;
    }

    public BookingRequest() {
    }

    public BookingDetail getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }
// Constructors, getters and setters


}


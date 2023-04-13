package com.bookingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String username;

    private String name;

    private Long flightId;

    private Long busId;

    private Long hotelId;

    private Long seatNo;

    private Long rooomNo;

    public BookingDetail(){

    }

    public BookingDetail(Long bookingId, String username, String name, Long flightId, Long busId, Long hotelId, Long seatNo, Long rooomNo) {
        this.bookingId = bookingId;
        this.username = username;
        this.name = name;
        this.flightId = flightId;
        this.busId = busId;
        this.hotelId = hotelId;
        this.seatNo = seatNo;
        this.rooomNo = rooomNo;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Long seatNo) {
        this.seatNo = seatNo;
    }

    public Long getRooomNo() {
        return rooomNo;
    }

    public void setRooomNo(Long rooomNo) {
        this.rooomNo = rooomNo;
    }
}

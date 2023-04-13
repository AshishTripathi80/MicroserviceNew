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
    public BookingDetail createBooking(BookingDetail booking) throws Exception {
        BookingDetail local=this.bookingRepository.findByBookingId(booking.getBookingId());
        if(local !=null){
            throw new Exception("Booking already done !!");
        }else{
            //user create
            local=this.bookingRepository.save(booking);
        }
        return local;
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

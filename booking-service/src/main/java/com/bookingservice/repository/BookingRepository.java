package com.bookingservice.repository;

import com.bookingservice.model.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingDetail,Long> {

    List<BookingDetail> findByUsername(String username);

    BookingDetail findByBookingId(Long bookingId);
}


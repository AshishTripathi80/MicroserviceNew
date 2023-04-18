package com.busservice.repository;


import com.busservice.model.BusDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusRepository  extends JpaRepository<BusDetail,Long> {

    @Query(value = "select * from BUS_DETAIL where from_City = ?1 and to_City=?2", nativeQuery = true)
    List<BusDetail> searchBusByFromCityAndToCity(String fromCity, String toCity);

}

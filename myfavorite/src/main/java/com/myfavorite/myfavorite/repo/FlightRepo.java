package com.myfavorite.myfavorite.repo;

import com.myfavorite.myfavorite.model.FlightDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<FlightDetail,Long> {
}

package com.myfavorite.myfavorite.repo;

import com.myfavorite.myfavorite.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Long> {

}

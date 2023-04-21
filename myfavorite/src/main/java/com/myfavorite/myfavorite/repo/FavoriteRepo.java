package com.myfavorite.myfavorite.repo;

import com.myfavorite.myfavorite.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite,Long> {

    List<Favorite> findByUsername(String username);
}

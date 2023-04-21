package com.myfavorite.myfavorite.controller;


import com.myfavorite.myfavorite.model.BusDetail;
import com.myfavorite.myfavorite.model.Favorite;
import com.myfavorite.myfavorite.model.FlightDetail;
import com.myfavorite.myfavorite.model.Hotel;
import com.myfavorite.myfavorite.repo.FavoriteRepo;
import com.myfavorite.myfavorite.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteRepo favoriteRepo;

    @Autowired
    private HotelRepo hotelRepo;



    @GetMapping("/getFavorite")
    public List<Favorite> getFavorite(@RequestParam(value = "username") String username){
        return favoriteRepo.findByUsername(username);
    }


    @PostMapping("/hotel")
    public Favorite saveFavorite(@RequestBody Hotel hotel, @RequestParam(value = "username") String username){
        Favorite favorite=new Favorite();
        favorite.setUsername(username);
        hotelRepo.save(hotel);
        favorite.setHotel(hotel);

        return favoriteRepo.save(favorite);
    }

    @DeleteMapping("/delete/hotel")
    public ResponseEntity<?> deleteHotelBooking(@RequestParam(value = "id") Long id) {
        Optional<Favorite> booking = favoriteRepo.findById(id);
        if (booking.isPresent()) {
            favoriteRepo.delete(booking.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/flight")
    public Favorite saveFavoriteFlight(@RequestBody FlightDetail flightDetail, @RequestParam(value = "username") String username){
        Favorite favorite=new Favorite();
        favorite.setUsername(username);
        favorite.setFlightDetail(flightDetail);

        return favoriteRepo.save(favorite);
    }

    @DeleteMapping("/delete/flight")
    public ResponseEntity<?> deleteFlightBooking(@RequestParam(value = "id") Long id) {
        Optional<Favorite> booking = favoriteRepo.findById(id);
        if (booking.isPresent()) {
            favoriteRepo.delete(booking.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bus")
    public Favorite saveFavoriteBus(@RequestBody BusDetail busDetail, @RequestParam(value = "username") String username){
        Favorite favorite=new Favorite();
        favorite.setUsername(username);
        favorite.setBusDetail(busDetail);

        return favoriteRepo.save(favorite);
    }

    @DeleteMapping("/delete/bus")
    public ResponseEntity<?> deleteBusBooking(@RequestParam(value = "id") Long id) {
        Optional<Favorite> booking = favoriteRepo.findById(id);
        if (booking.isPresent()) {
            favoriteRepo.delete(booking.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

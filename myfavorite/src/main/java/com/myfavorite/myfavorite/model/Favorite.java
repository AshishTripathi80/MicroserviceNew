package com.myfavorite.myfavorite.model;


import javax.persistence.*;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteId", insertable = false, updatable = false)
    private Long favoriteId;

    private String username;


    @ManyToOne
    @JoinColumn(name = "id")
    private Hotel hotel;


    @ManyToOne
    @JoinColumn(name = "busId")
    private BusDetail busDetail;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private FlightDetail flightDetail;

    public Favorite(Long favoriteId, String username, Hotel hotel, BusDetail busDetail,FlightDetail flightDetail) {
        this.favoriteId = favoriteId;
        this.username = username;
        this.hotel = hotel;
        this.busDetail = busDetail;
        this.flightDetail=flightDetail;
    }

    public Favorite() {
    }

    public FlightDetail getFlightDetail() {
        return flightDetail;
    }

    public void setFlightDetail(FlightDetail flightDetail) {
        this.flightDetail = flightDetail;
    }

    public Long getId() {
        return favoriteId;
    }

    public void setId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public BusDetail getBusDetail() {
        return busDetail;
    }

    public void setBusDetail(BusDetail busDetail) {
        this.busDetail = busDetail;
    }
}

package com.myfavorite.myfavorite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    private String busName;

    private String fromCity;

    private String toCity;

    private String date;

    public BusDetail(){

    }

    public BusDetail(Long flightId, String flightName, String fromCity, String toCity, String date) {
        this.busId = flightId;
        this.busName = flightName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.date = date;
    }

    public Long getBusId() {
        return busId;
    }

    public void seBusId(Long busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


package com.busservice.service;


import com.busservice.model.BusDetail;

public interface BusService {
    BusDetail createBus(BusDetail bus) ;

    BusDetail getBusDetail(long busId);

}
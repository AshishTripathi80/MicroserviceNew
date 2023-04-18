package com.busservice.service;

import com.busservice.model.BusDetail;
import org.springframework.beans.factory.annotation.Autowired;
import com.busservice.repository.BusRepository;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImp implements BusService {

    @Autowired
    private BusRepository busRepository;


    @Override
    public BusDetail createBus(BusDetail bus)  {

            //user create
            return this.busRepository.save(bus);
    }

    @Override
    public BusDetail getBusDetail(long busId) {
        return this.busRepository.findById(busId).orElse(null);
    }


}


package com.shopmanager.service.impl;

import com.shopmanager.dao.TransportationMapper;
import com.shopmanager.model.Transportation;
import com.shopmanager.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportationServiceImpl implements TransportationService {

    @Autowired
    private TransportationMapper transportationMapper;

    @Override
    public int add(Transportation transportation) {
        return transportationMapper.insert(transportation);
    }

    @Override
    public Transportation getByCartid(int cartid) {
        return transportationMapper.selectByCateId(cartid);
    }
}

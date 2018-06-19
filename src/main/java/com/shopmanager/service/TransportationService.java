package com.shopmanager.service;

import com.shopmanager.model.Transportation;

public interface TransportationService {
    int add(Transportation transportation);

    Transportation getByCartid(int cartid);
}

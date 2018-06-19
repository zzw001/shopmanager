package com.shopmanager.service;

import com.shopmanager.model.Subcata;

import java.util.List;

public interface SubCataService {

    List<Subcata> getByCataId(int cataid);

    List<Subcata> getAll();
}

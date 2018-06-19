package com.shopmanager.service.impl;

import com.shopmanager.dao.SubcataMapper;
import com.shopmanager.model.Subcata;
import com.shopmanager.service.SubCataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCataServiceImpl implements SubCataService {

    @Autowired
    private SubcataMapper subcataMapper;

    @Override
    public List<Subcata> getByCataId(int cataid) {
        return subcataMapper.selectByCataId(cataid);
    }

    @Override
    public List<Subcata> getAll() {
        return subcataMapper.selectAll();
    }
}

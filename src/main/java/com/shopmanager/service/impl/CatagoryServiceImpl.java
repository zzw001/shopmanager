package com.shopmanager.service.impl;

import com.shopmanager.dao.CatagoryMapper;
import com.shopmanager.model.Catagory;
import com.shopmanager.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryMapper catagoryMapper;

    @Override
    public List<Catagory> getAll() {
        return catagoryMapper.getAll();
    }
}

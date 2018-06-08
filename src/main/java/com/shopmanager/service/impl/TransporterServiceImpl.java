package com.shopmanager.service.impl;

import com.shopmanager.dao.TransporterMapper;
import com.shopmanager.model.Transporter;
import com.shopmanager.service.TransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransporterServiceImpl implements TransporterService {

    @Autowired
    private TransporterMapper transporterMapper;

    @Override
    public Transporter getByTranname(String tranname) {
        return transporterMapper.selectByTrerName(tranname);
    }
}

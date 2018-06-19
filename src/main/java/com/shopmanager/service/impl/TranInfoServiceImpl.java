package com.shopmanager.service.impl;

import com.shopmanager.dao.TranInfoMapper;
import com.shopmanager.model.TranInfo;
import com.shopmanager.service.TranInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranInfoServiceImpl implements TranInfoService {

    @Autowired
    private TranInfoMapper tranInfoMapper;

    @Override
    public int add(TranInfo tranInfo) {
        return tranInfoMapper.insert(tranInfo);
    }

    @Override
    public List<TranInfo> getByTranId(String tranid) {
        return tranInfoMapper.selectByTranId(tranid);
    }
}

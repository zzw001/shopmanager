package com.shopmanager.service;

import com.shopmanager.model.TranInfo;

import java.util.List;

public interface TranInfoService {
    int add(TranInfo tranInfo);

    List<TranInfo> getByTranId(String tranid);
}

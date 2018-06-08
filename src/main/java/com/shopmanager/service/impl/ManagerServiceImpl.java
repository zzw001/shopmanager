package com.shopmanager.service.impl;

import com.shopmanager.dao.ManagerMapper;
import com.shopmanager.model.Manager;
import com.shopmanager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager getByMananame(String mananame) {
        return managerMapper.selectByManaName(mananame);
    }
}

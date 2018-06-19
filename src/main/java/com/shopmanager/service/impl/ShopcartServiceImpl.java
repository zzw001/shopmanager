package com.shopmanager.service.impl;

import com.shopmanager.dao.ShopcartMapper;
import com.shopmanager.model.Shopcart;
import com.shopmanager.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcartServiceImpl implements ShopcartService {
    @Autowired
    private ShopcartMapper shopcartMapper;

    @Override
    public int add(Shopcart shopcart) {
        return shopcartMapper.insert(shopcart);
    }

    @Override
    public int update(Shopcart shopcart) {
        return shopcartMapper.updateByPrimaryKeySelective(shopcart);
    }

    @Override
    public int delete(int cartid) {
        return shopcartMapper.deleteByPrimaryKey(cartid);
    }

    @Override
    public List<Shopcart> getBuyByUserId(int userid) {
        return shopcartMapper.selectBuyByUserId(userid);
    }

    @Override
    public List<Shopcart> getNotBuyByUserId(int userid) {
        return shopcartMapper.selectNotBuyByUserId(userid);
    }

    @Override
    public Shopcart getShopcart(int proid, int userid) {
        return shopcartMapper.selectShopcart(proid,userid);
    }

    @Override
    public Shopcart getByCartid(int cartid) {
        return shopcartMapper.selectByPrimaryKey(cartid);
    }

    @Override
    public List<Shopcart> getAllBuy() {
        return shopcartMapper.selectAllBuy();
    }
}

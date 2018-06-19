package com.shopmanager.service;

import com.shopmanager.model.Shopcart;

import java.util.List;

public interface ShopcartService {
    int add(Shopcart shopcart);

    int update(Shopcart shopcart);

    int delete(int cartid);

    List<Shopcart> getBuyByUserId(int userid);

    List<Shopcart> getNotBuyByUserId(int userid);

    Shopcart getShopcart(int proid,int userid);

    Shopcart getByCartid(int cartid);

    List<Shopcart> getAllBuy();
}

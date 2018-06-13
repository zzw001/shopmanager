package com.shopmanager.service;

import com.shopmanager.model.Product;

import java.util.List;

public interface ProductService {
    int add(Product product);

    List<Product> getBySubId(int subid);

    Product getByProId(int id);

    List<Product> getBySearch(String search);
}

package com.shopmanager.service.impl;

import com.shopmanager.dao.ProductMapper;
import com.shopmanager.model.Product;
import com.shopmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int add(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public List<Product> getBySubId(int subid) {
        return productMapper.selectBySubId(subid);
    }

    @Override
    public Product getByProId(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> getBySearch(String search) {
        return productMapper.selectBySearch(search);
    }
}

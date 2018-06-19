package com.shopmanager.service.impl;

import com.shopmanager.dao.UserMapper;
import com.shopmanager.model.User;
import com.shopmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSeriveImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getByUserid(int userid) {
        return userMapper.selectByPrimaryKey(userid);
    }
}

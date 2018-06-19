package com.shopmanager.service;

import com.shopmanager.model.User;

public interface UserService {

    int add(User user);

    int update(User user);

    User getByUsername(String username);

    User getByUserid(int userid);
}

package com.nus.travel_website.dao;

import com.nus.travel_website.domain.User;

public interface UserDao {
    User findByEmail(String email);

    void save(User user);

    User findByCode(String code);

    void updateStatus(User user);
}

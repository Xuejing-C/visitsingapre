package com.nus.visitsingapore.dao;

import com.nus.visitsingapore.domain.User;

public interface UserDao {
    User findByEmail(String email);

    void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByEmailAndPassword(String email, String password);
}

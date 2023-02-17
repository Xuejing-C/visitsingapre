package com.nus.visitsingapore.service;

import com.nus.visitsingapore.domain.User;

public interface UserService {

    boolean register(User user);

    boolean activate(String code);

    User login(User user);
}

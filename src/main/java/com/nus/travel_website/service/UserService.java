package com.nus.travel_website.service;

import com.nus.travel_website.domain.User;

public interface UserService {

    boolean register(User user);

    boolean activate(String code);
}

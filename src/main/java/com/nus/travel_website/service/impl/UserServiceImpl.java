package com.nus.travel_website.service.impl;

import com.nus.travel_website.dao.UserDao;
import com.nus.travel_website.dao.impl.UserDaoImpl;
import com.nus.travel_website.domain.User;
import com.nus.travel_website.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public boolean register(User user) {
        User u = userDao.findByEmail(user.getEmail());
        if (u!= null) {
            // user already exists
            return false;
        }

        userDao.save(user);
        return true;
    }
}

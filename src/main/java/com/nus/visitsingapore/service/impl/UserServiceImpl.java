package com.nus.visitsingapore.service.impl;

import com.nus.visitsingapore.dao.UserDao;
import com.nus.visitsingapore.dao.impl.UserDaoImpl;
import com.nus.visitsingapore.domain.User;
import com.nus.visitsingapore.service.UserService;
import com.nus.visitsingapore.util.MailUtils;
import com.nus.visitsingapore.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public boolean register(User user) {
        User u = userDao.findByEmail(user.getEmail());
        if (u!= null) {
            // user already exists
            return false;
        }

        // set activation status and code
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());
        // save user info
        userDao.save(user);
        // send activation email
        String content = "<a href='http://localhost:8080/visitsingapore/activeUserServlet?code="
                +user.getCode()+"'>Click to activate your account on tourism info website</a>";
        MailUtils.sendMail(user.getEmail(),content,"Activation Email");
        return true;
    }

    @Override
    public boolean activate(String code) {
        User user = userDao.findByCode(code);
        if (user != null) {
            userDao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        User u = userDao.findByEmailAndPassword(user.getEmail(),user.getPassword());
        return u;
    }
}

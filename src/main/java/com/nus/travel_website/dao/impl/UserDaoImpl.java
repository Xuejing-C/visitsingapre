package com.nus.travel_website.dao.impl;

import com.nus.travel_website.dao.UserDao;
import com.nus.travel_website.domain.User;
import com.nus.travel_website.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());
    public User findByEmail(String email) {
        User user = null;
        try {
            String sql = "select * from tab_user where email = ?";
            // BeanPropertyRowMapper：automatically encapsulate query result as JavaBean class
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email);
        } catch (DataAccessException e) {
            // exception will occur when there is no query result
            // catch this exception
            // final return value will be null
        }
        return user;
    }

    public void save(User user) {
        String birthday = user.getBirthday();
        if (birthday == "") {
            String sql = "insert into tab_user(email,username,password,gender,telephone,status,code) values(?,?,?,?,?,?,?)";
            template.update(sql,
                    user.getEmail(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getGender(),
                    user.getTelephone(),
                    user.getStatus(),
                    user.getCode()
            );
        } else {
            String sql = "insert into tab_user(email,username,password,birthday,gender,telephone,status,code) values(?,?,?,?,?,?,?,?)";
            template.update(sql,
                    user.getEmail(),
                    user.getUsername(),
                    user.getPassword(),
                    birthday,
                    user.getGender(),
                    user.getTelephone(),
                    user.getStatus(),
                    user.getCode()
            );
        }
    }

    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (DataAccessException e) {
        }
        return user;
    }

    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid = ?";
        template.update(sql, user.getUid());
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User user = null;
        try {
            String sql = "select * from tab_user where email = ? and password = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email, password);
        } catch (DataAccessException e) {
        }
        return user;
    }
}

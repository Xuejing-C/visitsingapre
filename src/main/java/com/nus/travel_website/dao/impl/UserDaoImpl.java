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
}

package com.nus.visitsingapore.dao.impl;

import com.nus.visitsingapore.dao.FavoriteDao;
import com.nus.visitsingapore.domain.Favorite;
import com.nus.visitsingapore.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Favorite findByUidAndVid(int uid, int vid) {
        Favorite favorite = null;
        try {
            String sql = " select * from tab_favorite where uid = ? and vid = ?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class),uid,vid);
        } catch (DataAccessException e) {
        }
        return favorite;
    }

    @Override
    public int findCountByVid(int vid) {
        String sql = "SELECT COUNT(*) FROM tab_favorite WHERE vid = ?";
        return template.queryForObject(sql, Integer.class, vid);
    }

    @Override
    public void add(int uid, int vid) {
        String sql = "insert into tab_favorite values(?,?,?)";
        template.update(sql,uid,vid,new Date());
    }
}

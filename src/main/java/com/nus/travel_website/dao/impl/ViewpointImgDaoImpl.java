package com.nus.travel_website.dao.impl;

import com.nus.travel_website.dao.ViewpointDao;
import com.nus.travel_website.dao.ViewpointImgDao;
import com.nus.travel_website.domain.Image;
import com.nus.travel_website.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ViewpointImgDaoImpl implements ViewpointImgDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Image> findByVid(int vid) {
        String sql = "select * from tab_viewpoint_img where vid = ?";
        return template.query(sql, new BeanPropertyRowMapper<Image>(Image.class),vid);
    }
}

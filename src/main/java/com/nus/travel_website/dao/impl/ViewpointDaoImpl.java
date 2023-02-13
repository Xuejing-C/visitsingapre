package com.nus.travel_website.dao.impl;

import com.nus.travel_website.dao.ViewpointDao;
import com.nus.travel_website.domain.Viewpoint;
import com.nus.travel_website.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ViewpointDaoImpl implements ViewpointDao {
    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_viewpoint where cid = ?";
        return template.queryForObject(sql, Integer.class, cid);
    }

    @Override
    public List<Viewpoint> findPageContent(int cid, int start, int pageSize) {
        String sql = "select * from tab_viewpoint where cid = ? limit ?, ?";
        return template.query(sql, new BeanPropertyRowMapper<Viewpoint>(Viewpoint.class), cid, start, pageSize);
    }
}

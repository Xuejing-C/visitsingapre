package com.nus.travel_website.dao.impl;

import com.nus.travel_website.dao.ViewpointDao;
import com.nus.travel_website.domain.Viewpoint;
import com.nus.travel_website.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ViewpointDaoImpl implements ViewpointDao {
    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid, String vname) {
        String sql = "select count(*) from tab_viewpoint where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();

        if (cid != 0) {
            sb.append(" and cid = ?");
            params.add(cid);
        }
        if (vname != null && vname.length() > 0) {
            sb.append(" and vname like ?");
            params.add("%"+vname+"%");
        }
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<Viewpoint> findPageContent(int cid, int start, int pageSize, String vname) {
        String sql = "select * from tab_viewpoint where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();

        if (cid != 0) {
            sb.append(" and cid = ?");
            params.add(cid);
        }
        if (vname != null && vname.length() > 0) {
            sb.append(" and vname like ?");
            params.add("%"+vname+"%");
        }
        sb.append(" limit ?, ?");
        params.add(start);
        params.add(pageSize);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Viewpoint>(Viewpoint.class), params.toArray());
    }
}

package com.nus.travel_website.dao.impl;
import com.nus.travel_website.dao.CategoryDao;
import com.nus.travel_website.domain.Category;
import com.nus.travel_website.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findCategory() {
        String sql = "select * from tab_category";
        List<Category> categories = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        return categories;
    }
}

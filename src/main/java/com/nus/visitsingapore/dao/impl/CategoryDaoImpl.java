package com.nus.visitsingapore.dao.impl;
import com.nus.visitsingapore.dao.CategoryDao;
import com.nus.visitsingapore.domain.Category;
import com.nus.visitsingapore.util.JDBCUtils;
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

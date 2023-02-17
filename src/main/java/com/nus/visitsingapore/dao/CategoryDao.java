package com.nus.visitsingapore.dao;

import com.nus.visitsingapore.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findCategory();
}

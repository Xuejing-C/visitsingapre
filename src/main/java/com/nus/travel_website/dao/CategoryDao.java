package com.nus.travel_website.dao;

import com.nus.travel_website.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findCategory();
}

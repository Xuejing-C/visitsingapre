package com.nus.visitsingapore.service.impl;

import com.nus.visitsingapore.dao.CategoryDao;
import com.nus.visitsingapore.dao.impl.CategoryDaoImpl;
import com.nus.visitsingapore.domain.Category;
import com.nus.visitsingapore.service.CategoryService;
import com.nus.visitsingapore.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findCategory() {
        Jedis jedis = JedisUtil.getJedis();
        Set<Tuple> categories = jedis.zrangeWithScores("category", 0, -1);

        List<Category> res = null;
        if (categories == null || categories.size() == 0) {
            res = categoryDao.findCategory();

            // save data into redis
            for (int i = 0; i < res.size(); i++) {
                jedis.zadd("category", res.get(i).getCid(), res.get(i).getCname());
            }
        } else {
            res = new ArrayList<Category>() ;
            for (Tuple tuple : categories) {
                Category category = new Category((int) tuple.getScore(), tuple.getElement());
                res.add(category);
            }
        }
        return res;
    }
}

package com.nus.visitsingapore.dao;

import com.nus.visitsingapore.domain.Favorite;

public interface FavoriteDao {
    Favorite findByUidAndVid(int uid, int vid);

    int findCountByVid(int vid);

    void add(int uid, int vid);
}

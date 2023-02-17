package com.nus.visitsingapore.service.impl;

import com.nus.visitsingapore.dao.FavoriteDao;
import com.nus.visitsingapore.dao.impl.FavoriteDaoImpl;
import com.nus.visitsingapore.domain.Favorite;
import com.nus.visitsingapore.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(int uid, int vid) {
        Favorite favorite = favoriteDao.findByUidAndVid(uid, vid);
        return favorite != null;
    }

    @Override
    public void addFavorite(int uid, int vid) {
        favoriteDao.add(uid, vid);
    }
}

package com.nus.visitsingapore.service;

public interface FavoriteService {

    boolean isFavorite(int uid, int vid);

    void addFavorite(int uid, int vid);
}

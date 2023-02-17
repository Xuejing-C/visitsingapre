package com.nus.visitsingapore.dao;

import com.nus.visitsingapore.domain.Image;

import java.util.List;

public interface ViewpointImgDao {
    List<Image> findByVid(int vid);
}

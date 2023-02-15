package com.nus.travel_website.dao;

import com.nus.travel_website.domain.Image;

import java.util.List;

public interface ViewpointImgDao {
    List<Image> findByVid(int vid);
}

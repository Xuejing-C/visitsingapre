package com.nus.travel_website.dao;

import com.nus.travel_website.domain.Viewpoint;

import java.util.List;

public interface ViewpointDao {
    int findTotalCount(int cid);

    List<Viewpoint> findPageContent(int cid, int start, int pageSize);
}
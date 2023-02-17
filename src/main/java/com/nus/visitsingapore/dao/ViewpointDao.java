package com.nus.visitsingapore.dao;

import com.nus.visitsingapore.domain.Viewpoint;

import java.util.List;

public interface ViewpointDao {
    int findTotalCount(int cid, String vname);

    List<Viewpoint> findPageContent(int cid, int start, int pageSize, String vname);

    Viewpoint findDetail(int vid);
}

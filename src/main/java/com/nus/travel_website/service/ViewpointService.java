package com.nus.travel_website.service;

import com.nus.travel_website.domain.PageBean;
import com.nus.travel_website.domain.Viewpoint;

public interface ViewpointService {

    PageBean<Viewpoint> pageQuery(int cid, int pageSize, int currentPageNum, String vname);

    Viewpoint findDetail(int vid);
}

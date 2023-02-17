package com.nus.visitsingapore.service;

import com.nus.visitsingapore.domain.PageBean;
import com.nus.visitsingapore.domain.Viewpoint;

public interface ViewpointService {

    PageBean<Viewpoint> pageQuery(int cid, int pageSize, int currentPageNum, String vname);

    Viewpoint findDetail(int vid);
}

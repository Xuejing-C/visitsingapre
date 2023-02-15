package com.nus.travel_website.service.impl;

import com.nus.travel_website.dao.ViewpointDao;
import com.nus.travel_website.dao.ViewpointImgDao;
import com.nus.travel_website.dao.impl.ViewpointDaoImpl;
import com.nus.travel_website.dao.impl.ViewpointImgDaoImpl;
import com.nus.travel_website.domain.Image;
import com.nus.travel_website.domain.PageBean;
import com.nus.travel_website.domain.Viewpoint;
import com.nus.travel_website.service.ViewpointService;

import java.util.List;

public class ViewpointServiceImpl implements ViewpointService {
    private ViewpointDao viewpointDao = new ViewpointDaoImpl();
    private ViewpointImgDao viewpointImgDao = new ViewpointImgDaoImpl();
    @Override
    public PageBean<Viewpoint> pageQuery(int cid, int pageSize, int currentPageNum, String vname) {
        PageBean<Viewpoint> pageBean = new PageBean<>();

        int totalCount = viewpointDao.findTotalCount(cid,vname);
        pageBean.setTotalCount(totalCount);
        pageBean.setPageSize(pageSize);
        int totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);
        pageBean.setcurrentPageNum(currentPageNum);

        int start = (currentPageNum - 1) * pageSize;
        List<Viewpoint> pageContent = viewpointDao.findPageContent(cid, start, pageSize, vname);
        pageBean.setVpList(pageContent);
        return pageBean;
    }

    @Override
    public Viewpoint findDetail(int vid) {
        Viewpoint viewpoint = viewpointDao.findDetail(vid);
        List<Image> imgList = viewpointImgDao.findByVid(vid);
        viewpoint.setImgList(imgList);

        return viewpoint;
    }
}

package com.nus.visitsingapore.service.impl;

import com.nus.visitsingapore.dao.FavoriteDao;
import com.nus.visitsingapore.dao.ViewpointDao;
import com.nus.visitsingapore.dao.ViewpointImgDao;
import com.nus.visitsingapore.dao.impl.FavoriteDaoImpl;
import com.nus.visitsingapore.dao.impl.ViewpointDaoImpl;
import com.nus.visitsingapore.dao.impl.ViewpointImgDaoImpl;
import com.nus.visitsingapore.domain.Image;
import com.nus.visitsingapore.domain.PageBean;
import com.nus.visitsingapore.domain.Viewpoint;
import com.nus.visitsingapore.service.ViewpointService;

import java.util.List;

public class ViewpointServiceImpl implements ViewpointService {
    private ViewpointDao viewpointDao = new ViewpointDaoImpl();
    private ViewpointImgDao viewpointImgDao = new ViewpointImgDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
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
        int count = favoriteDao.findCountByVid(vid);
        viewpoint.setFavCount(count);
        return viewpoint;
    }
}

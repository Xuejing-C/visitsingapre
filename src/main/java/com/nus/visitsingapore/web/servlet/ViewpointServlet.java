package com.nus.visitsingapore.web.servlet;

import com.nus.visitsingapore.domain.PageBean;
import com.nus.visitsingapore.domain.User;
import com.nus.visitsingapore.domain.Viewpoint;
import com.nus.visitsingapore.service.FavoriteService;
import com.nus.visitsingapore.service.ViewpointService;
import com.nus.visitsingapore.service.impl.FavoriteServiceImpl;
import com.nus.visitsingapore.service.impl.ViewpointServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/viewpoint/*")
public class ViewpointServlet extends BaseServlet {
    private ViewpointService service = new ViewpointServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cidStr = request.getParameter("cid");
        String pageSizeStr = request.getParameter("pageSize");
        String currentPageNumStr = request.getParameter("currentPageNum");
        String vname = request.getParameter("vname");

        int cid = 0;
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        int pageSize = 3;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        int currentPageNum = 1;
        if (currentPageNumStr != null && currentPageNumStr.length() > 0 && !"0".equals(currentPageNumStr)) {
            currentPageNum = Integer.parseInt(currentPageNumStr);
        }

        PageBean<Viewpoint> pageBean = service.pageQuery(cid, pageSize, currentPageNum, vname);
        writeValue(pageBean, response);
    }

    public void findDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vidStr = request.getParameter("vid");
        int vid = Integer.parseInt(vidStr);
        Viewpoint viewpoint = service.findDetail(vid);
        writeValue(viewpoint, response);
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vid = request.getParameter("vid");
        User user = (User) request.getSession().getAttribute("user");

        int uid;
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }
        boolean flag = favoriteService.isFavorite(uid, Integer.parseInt(vid));
        writeValue(flag,response);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vid = request.getParameter("vid");
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        favoriteService.addFavorite(uid, Integer.parseInt(vid));
    }
}

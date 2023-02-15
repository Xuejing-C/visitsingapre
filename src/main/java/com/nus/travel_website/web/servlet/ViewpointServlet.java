package com.nus.travel_website.web.servlet;

import com.nus.travel_website.domain.PageBean;
import com.nus.travel_website.domain.Viewpoint;
import com.nus.travel_website.service.ViewpointService;
import com.nus.travel_website.service.impl.ViewpointServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/viewpoint/*")
public class ViewpointServlet extends BaseServlet {
    private ViewpointService service = new ViewpointServiceImpl();
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
}

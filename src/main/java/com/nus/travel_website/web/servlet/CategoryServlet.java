package com.nus.travel_website.web.servlet;

import com.nus.travel_website.domain.Category;
import com.nus.travel_website.service.CategoryService;
import com.nus.travel_website.service.impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServiceImpl();

    public void findCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = service.findCategory();
        writeValue(categories,response);
    }

}

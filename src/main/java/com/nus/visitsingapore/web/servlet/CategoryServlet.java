package com.nus.visitsingapore.web.servlet;

import com.nus.visitsingapore.domain.Category;
import com.nus.visitsingapore.service.CategoryService;
import com.nus.visitsingapore.service.impl.CategoryServiceImpl;

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

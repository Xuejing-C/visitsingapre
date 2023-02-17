package com.nus.visitsingapore.web.servlet;

import com.nus.visitsingapore.service.UserService;
import com.nus.visitsingapore.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code != null) {
            // activate user account
            UserService service = new UserServiceImpl();
            boolean flag =  service.activate(code);

            String msg = null;
            if (flag) {
                msg = "Activation succeed. Please <a href='login.html'>log in.</a>";
            } else {
                msg = "Activation fail. Please contact xxx@gmail.com";
            }
            response.setContentType("text/html");
            response.getWriter().write(msg);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

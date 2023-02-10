package com.nus.travel_website.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.travel_website.domain.ResultInfo;
import com.nus.travel_website.domain.User;
import com.nus.travel_website.service.impl.UserServiceImpl;
import com.nus.travel_website.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); // ensure check code can only be used once
        String check = request.getParameter("check");
        System.out.println(check);

        ResultInfo info = new ResultInfo();
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)) {
            // check code validation fail
            info.setFlag(false);
            info.setErrorMsg("Wrong check code...");
        } else {
            Map<String, String[]> map = request.getParameterMap();

            // encapsulate request data to User object
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            UserService service = new UserServiceImpl();
            User u = service.login(user);

            if (u == null) {
                info.setFlag(false);
                info.setErrorMsg("Wrong email or password.");
            } else {
                if ("Y".equals(u.getStatus())){
                    info.setFlag(true);
                    request.getSession().setAttribute("user", u);
                } else {
                    info.setFlag(false);
                    info.setErrorMsg("Account has not been activated.");
                }
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}

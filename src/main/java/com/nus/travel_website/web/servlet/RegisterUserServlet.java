package com.nus.travel_website.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.travel_website.domain.ResultInfo;
import com.nus.travel_website.domain.User;
import com.nus.travel_website.service.UserService;
import com.nus.travel_website.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0. validate check code
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); // ensure check code can only be used once
        String check = request.getParameter("check");

        ResultInfo resultInfo = new ResultInfo();
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)) {
            // check code validation fail
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("Wrong check code...");
        } else {
            // check code validation succeed
            // 1. acquire request data
            Map<String, String[]> map = request.getParameterMap();

            // 2. encapsulate request data to User object
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            // 3. call service to complete registration
            UserService service = new UserServiceImpl();
            boolean flag = service.register(user);

            // 4. set result
            if(flag) {
                // registration success
                resultInfo.setFlag(true);
            }else {
                // registration fail
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("Email already exists...Please log in directly...");
            }
        }

        // 5. convert ResultInfo object to json format using Jackson
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        // 6. set response
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
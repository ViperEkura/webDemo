package com.elm.controller;

import com.elm.entity.User;
import com.elm.service.UserService;
import com.elm.service.impl.UserServiceImpl;
import com.elm.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserController/*")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String action = req.getPathInfo();
            PrintWriter out = resp.getWriter();

            if (action.equals("/getUserById")) {
                String userId = req.getParameter("userId");
                int count = userService.getUserById(userId);
                out.print(JsonUtil.toJson(count));
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String action = req.getPathInfo();
            PrintWriter out = resp.getWriter();
            User user = new User();

            switch (action) {
                case "/saveUser" -> {
                    user.setUserId(req.getParameter("userId"));
                    user.setPassword(req.getParameter("password"));
                    int result = userService.saveUser(user);
                    out.print(JsonUtil.toJson(result));
                }
                case "/getUserByIdByPass" -> {
                    String userId = req.getParameter("userId");
                    String password = req.getParameter("password");
                    User dbUser = userService.getUserByIdByPass(userId, password);
                    out.print(JsonUtil.toJson(dbUser));
                }
                default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
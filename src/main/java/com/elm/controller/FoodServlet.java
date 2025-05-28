package com.elm.controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/FoodController/*")
public class FoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String action = req.getPathInfo();
            PrintWriter out = resp.getWriter();

            switch (action){
                case "/listFoodByBusinessId" -> {

                }
                default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }

        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



}

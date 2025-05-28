package com.elm.controller;


import com.elm.entity.Food;
import com.elm.service.FoodService;
import com.elm.service.impl.FoodServiceImpl;
import com.elm.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/FoodController/*")
public class FoodServlet extends HttpServlet {
    FoodService foodService = new FoodServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String action = req.getPathInfo();
            PrintWriter out = resp.getWriter();

            switch (action){
                case "/listFoodByBusinessId" -> {
                    Integer businessId = Integer.parseInt(req.getParameter("businessId"));
                    List<Food> listFood = foodService.listFoodByBusinessId(businessId);
                    out.println(JsonUtil.toJson(listFood));
                    System.out.println(JsonUtil.toJson(listFood));
                }

                default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }

        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



}

package com.elm.controller;


import com.elm.entity.Business;
import com.elm.service.BusinessService;
import com.elm.service.impl.BusinessServiceImpl;
import com.elm.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/BusinessController/*")
public class BusinessServlet extends HttpServlet {
    private final BusinessService businessService = new BusinessServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String action = req.getPathInfo();
            PrintWriter out = resp.getWriter();

            switch (action) {
                case "/listBusinessByOrderTypeId" -> {
                    Integer orderTypeId = Integer.parseInt(req.getParameter("orderTypeId"));
                    List<Business> businesses = businessService.listBusinessByOrderTypeId(orderTypeId);
                    out.print(JsonUtil.toJson(businesses));
                }
                case "/getBusinessById" -> {
                    Integer businessId = Integer.parseInt(req.getParameter("businessId"));
                    Business business = businessService.getBusinessById(businessId);
                    out.print(JsonUtil.toJson(business));
                }
                default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

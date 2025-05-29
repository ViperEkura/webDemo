package com.elm.controller;

import com.elm.service.DeliveryAddressService;
import com.elm.service.impl.DeliveryAddressServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/DeliveryAddressController/*")
public class DeliveryAddressServlet extends HttpServlet {
    private final DeliveryAddressService service = new DeliveryAddressServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String action = req.getPathInfo();
            PrintWriter out = resp.getWriter();

            switch (action){
                case "istDeliveryAddressByUserId" ->{
                    String userId = req.getParameter("uerId");
                    service.istDeliveryAddressByUserId(userId);
                }
                default ->  resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

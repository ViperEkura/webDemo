package com.elm.controller;

import com.elm.entity.OrderDetailet;
import com.elm.entity.Orders;
import com.elm.service.OrdersService;
import com.elm.service.impl.OrdersServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.elm.utils.JsonUtil;
import com.google.gson.reflect.TypeToken;


@WebServlet("/OrdersController/*")
public class OrdersServlet extends HttpServlet {

    private final OrdersService service = new OrdersServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = req.getPathInfo();
            switch (path) {
                case "/createOrders" -> createOrders(req, resp);
                case "/addOrderDetails" -> addOrderDetails(req, resp);
                case "/updateOrderState" -> updateOrderState(req, resp);
                case "/deleteOrderById" -> deleteOrderById(req, resp);
                case "/listOrdersByUserId" -> listOrdersByUserId(req, resp);
                case "/getOrdersById" -> getOrdersById(req, resp);
                default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND, "API Not Found");
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    private void createOrders(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Orders order = new Orders();

        order.setUserId(req.getParameter("userId"));
        order.setBusinessId(Integer.parseInt(req.getParameter("businessId")));
        order.setDaId(Integer.parseInt(req.getParameter("daId"))); //null
        order.setOrderTotal(Double.parseDouble(req.getParameter("orderTotal")));
        int result = service.createOrders(order);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JsonUtil.toJson(result));
    }

    private void listOrdersByUserId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userId = req.getParameter("userId");
        List<Orders> orders = service.listOrdersByUserId(userId);
        String json = JsonUtil.toJson(orders);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    private void getOrdersById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        Orders order = service.getOrdersById(orderId);
        String json = JsonUtil.toJson(order);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    private void addOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        BufferedReader reader = req.getReader();

        Type listType = new TypeToken<List<OrderDetailet>>(){}.getType();
        List<OrderDetailet> details = JsonUtil.fromJson(reader, listType);
        int result = service.addOrderDetails(orderId, details);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JsonUtil.toJson(result));
    }

    private void updateOrderState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        Integer orderState = Integer.parseInt(req.getParameter("orderState"));
        int result = service.updateOrderState(orderId, orderState);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JsonUtil.toJson(result));
    }

    private void deleteOrderById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        int result = service.deleteOrderById(orderId);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JsonUtil.toJson(result));
    }
}
package com.elm.controller;

import com.elm.entity.OrderDetailet;
import com.elm.entity.Orders;
import com.elm.service.OrdersService;
import com.elm.service.impl.OrdersServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo(); // 获取子路径，如 /createOrder

        switch (path) {
            case "/createOrder" -> createOrder(req, resp);
            case "/addOrderDetails" -> addOrderDetails(req, resp);
            case "/updateOrderState" -> updateOrderState(req, resp);
            case "/deleteOrderById" -> deleteOrderById(req, resp);
            default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND, "API Not Found");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        switch (path) {
            case "/listOrdersByUserId" -> listOrdersByUserId(req, resp);
            case "/getOrdersById" -> getOrdersById(req, resp);
            default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND, "API Not Found");
        }
    }

    // 创建订单
    private void createOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Orders order = JsonUtil.fromJson(reader, Orders.class);
        int result = service.createOrder(order);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JsonUtil.toJson(result));
    }

    // 查询某个用户的订单列表
    private void listOrdersByUserId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userId = req.getParameter("userId");
        List<Orders> orders = service.listOrdersByUserId(userId);
        String json = JsonUtil.toJson(orders);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    // 根据订单ID查询订单
    private void getOrdersById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        Orders order = service.getOrdersById(orderId);
        String json = JsonUtil.toJson(order);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    // 添加订单详情
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

    // 修改订单状态
    private void updateOrderState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        Integer orderState = Integer.parseInt(req.getParameter("orderState"));
        int result = service.updateOrderState(orderId, orderState);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JsonUtil.toJson(result));
    }

    // 删除订单
    private void deleteOrderById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        int result = service.deleteOrderById(orderId);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JsonUtil.toJson(result));
    }
}
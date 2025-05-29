package com.elm.service.impl;

import com.elm.dao.OrderDao;
import com.elm.dao.impl.OrderDaoImpl;
import com.elm.entity.OrderDetailet;
import com.elm.entity.Orders;
import com.elm.service.OrdersService;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public int createOrders(Orders orders) {
        return orderDao.createOrder(orders);
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return orderDao.listOrdersByUserId(userId);
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return orderDao.getOrdersById(orderId);
    }

    @Override
    public int addOrderDetails(Integer orderId, List<OrderDetailet> details) {
        return orderDao.addOrderDetails(orderId, details);
    }

    @Override
    public int updateOrderState(Integer orderId, Integer orderState) {
        return orderDao.updateOrderState(orderId, orderState);
    }

    @Override
    public int deleteOrderById(Integer orderId) {
        return orderDao.deleteOrderById(orderId);
    }
}

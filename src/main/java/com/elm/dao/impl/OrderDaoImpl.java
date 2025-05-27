package com.elm.dao.impl;

import com.elm.dao.OrderDao;
import com.elm.entity.OrderDetailet;
import com.elm.entity.Orders;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int createOrder(Orders orders) {
        return 0;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return null;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return null;
    }

    @Override
    public int addOrderDetails(Integer orderId, List<OrderDetailet> details) {
        return 0;
    }

    @Override
    public int updateOrderState(Integer orderId, Integer orderState) {
        return 0;
    }

    @Override
    public int deleteOrderById(Integer orderId) {
        return 0;
    }
}

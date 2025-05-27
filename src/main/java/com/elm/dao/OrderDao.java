package com.elm.dao;

import com.elm.entity.OrderDetailet;
import com.elm.entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    int createOrder(Orders orders) throws SQLException;
    List<Orders> listOrdersByUserId(String userId);
    Orders getOrdersById(Integer orderId);
    int addOrderDetails(Integer orderId, List<OrderDetailet> details);
    int updateOrderState(Integer orderId, Integer orderState);
    int deleteOrderById(Integer orderId);
}

package com.elm.service;

import com.elm.entity.OrderDetailet;
import com.elm.entity.Orders;

import java.util.List;

public interface OrdersService {

    int createOrders(Orders orders);
    List<Orders> listOrdersByUserId(String userId);
    Orders getOrdersById(Integer orderId);
    int addOrderDetails(Integer orderId, List<OrderDetailet> details);
    int updateOrderState(Integer orderId, Integer orderState);
    int deleteOrderById(Integer orderId);

}

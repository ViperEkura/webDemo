package com.elm.dao.impl;

import com.elm.dao.OrderDao;
import com.elm.entity.OrderDetailet;
import com.elm.entity.Orders;
import com.elm.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int createOrder(Orders orders) {
        return 0;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        List<Orders> ordersList = new ArrayList<>();
        String sql = "SELECT * FROM Orders WHERE userId = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getString("userId"));
                order.setBusinessId(rs.getInt("businessId"));
                order.setOrderDate(rs.getString("orderDate")); // 注意日期格式转换
                order.setOrderTotal(rs.getDouble("orderTotal"));
                order.setDaId(rs.getInt("daId"));
                order.setOrderState(rs.getInt("orderState"));

                ordersList.add(order);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return ordersList;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {

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

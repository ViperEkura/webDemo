package com.elm.dao.impl;

import com.elm.dao.CartDao;
import com.elm.entity.Cart;
import com.elm.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public List<Cart> listCartByUserId(String userId) {
        List<Cart> listCart = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE userId = ?";

        try(Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            Cart cart;
            while (rs.next()){
                cart = new Cart();
                cart.setCartId(rs.getInt("cartId"));
                cart.setFoodId(rs.getInt("foodId"));
                cart.setBusinessId(rs.getInt("businessId"));
                cart.setUserId(rs.getString("userId"));
                cart.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询失败", e);
        }

        return  listCart;
    }

    @Override
    public int saveCart(Cart cart) {
        String sql = "INSERT INTO cart (foodId, businessId, userId, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cart.getFoodId());
            stmt.setInt(2, cart.getBusinessId());
            stmt.setString(3, cart.getUserId());
            stmt.setInt(4, cart.getQuantity());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询失败", e);
        }
    }

    @Override
    public int updateCart(Cart cart) {
        String sql = "UPDATE cart SET quantity = ? WHERE businessId = ? AND userId = ? AND foodId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cart.getQuantity());
            stmt.setInt(2, cart.getBusinessId());
            stmt.setString(3, cart.getUserId());
            stmt.setInt(4, cart.getFoodId());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询失败", e);
        }
    }

    @Override
    public int removeCart(Cart cart) {
        String sql = "DELETE FROM cart WHERE businessId = ? AND userId = ? AND foodId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cart.getBusinessId());
            stmt.setString(2, cart.getUserId());
            stmt.setInt(3, cart.getFoodId());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询失败", e);
        }
    }
}

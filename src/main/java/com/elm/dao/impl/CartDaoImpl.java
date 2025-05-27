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
    public List<Cart> listCartByUserId(Integer userId) {
        List<Cart> listCart = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE userId = ?";

        try(Connection conn = DbUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            Cart cart = null;
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
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cart.getFoodId());
            pstmt.setInt(2, cart.getBusinessId());
            pstmt.setString(3, cart.getUserId());
            pstmt.setInt(4, cart.getQuantity());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("添加购物车失败", e);
        }
    }

    @Override
    public int updateCart(Cart cart) {
        String sql = "UPDATE cart SET quantity = ? WHERE businessId = ? AND userId = ? AND foodId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cart.getQuantity());
            pstmt.setInt(2, cart.getBusinessId());
            pstmt.setString(3, cart.getUserId());
            pstmt.setInt(4, cart.getFoodId());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("更新购物车失败", e);
        }
    }

    @Override
    public int removeCart(Cart cart) {
        String sql = "DELETE FROM cart WHERE businessId = ? AND userId = ? AND foodId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cart.getBusinessId());
            pstmt.setString(2, cart.getUserId());
            pstmt.setInt(3, cart.getFoodId());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("删除购物车记录失败", e);
        }
    }
}

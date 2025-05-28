package com.elm.dao.impl;

import com.elm.dao.FoodDao;
import com.elm.entity.Food;
import com.elm.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        String sql = "SELECT * FROM food WHERE businessId = ?";
        List<Food> foodList = new ArrayList<>();

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, businessId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Food food = new Food();
                    food.setFoodId(rs.getInt("foodId"));
                    food.setFoodName(rs.getString("foodName"));
                    food.setFoodExplain(rs.getString("foodExplain"));
                    food.setFoodImg(rs.getString("foodImg"));
                    food.setFoodPrice(rs.getDouble("foodPrice"));
                    food.setBusinessId(rs.getInt("businessId"));
                    food.setRemarks(rs.getString("remarks"));
                    foodList.add(food);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("根据商家ID查询食品列表失败，商家ID: " + businessId, e);
        }
        return foodList;
    }
}

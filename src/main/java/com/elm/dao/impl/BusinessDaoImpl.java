package com.elm.dao.impl;

import com.elm.dao.BusinessDao;
import com.elm.entity.Business;
import com.elm.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        List<Business> businesses = new ArrayList<>();
        String sql = "SELECT * FROM business WHERE orderTypeId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, orderTypeId);
            ResultSet rs = stmt.executeQuery();
            Business business;

            while (rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));

                businesses.add(business);
            }
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询失败", e);
        }

        return businesses;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        String sql = "SELECT * FROM business WHERE businessId = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, businessId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));

                return business;
            }
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询失败", e);
        }

        return null;
    }
}

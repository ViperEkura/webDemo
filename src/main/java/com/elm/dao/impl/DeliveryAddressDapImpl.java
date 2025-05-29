package com.elm.dao.impl;

import com.elm.dao.DeliveryAddressDao;
import com.elm.entity.DeliveryAddress;
import com.elm.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDapImpl implements DeliveryAddressDao {
    public List<DeliveryAddress> istDeliveryAddressByUserId(String userId){
        List<DeliveryAddress> addresses = new ArrayList<>();
        String sql = "SELECT * FROM deliveryaddress WHERE userId = ?";

        try (Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1 , userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DeliveryAddress address = new DeliveryAddress();
                address.setUserId(rs.getString("userId"));
                address.setContactName(rs.getString("contactName"));
                address.setContactSex(rs.getInt("contactSex"));
                address.setContactTel(rs.getString("contactTel"));
                address.setAddress(rs.getString("address"));
                addresses.add(address);

            }
            return  addresses;
        } catch (Exception e){
            throw new RuntimeException("数据库查询失败", e);
        }
    }

    public int saveDeliveryAddress(DeliveryAddress address) {
        String sql = "INSERT INTO deliveryaddress " +
                "(userId, contactName, contactSex, contactTel, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, address.getUserId());
            stmt.setString(2, address.getContactName());
            stmt.setInt(3, address.getContactSex());
            stmt.setString(4, address.getContactTel());
            stmt.setString(5, address.getAddress());
            return  stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("数据库查询失败", e);
        }
    }

}

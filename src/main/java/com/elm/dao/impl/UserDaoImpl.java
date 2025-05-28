package com.elm.dao.impl;

import com.elm.dao.UserDao;
import com.elm.entity.User;
import com.elm.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO user(userId, password, userName, userSex) VALUES(?,?,?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getUserName());
            stmt.setInt(4, user.getUserSex());
            return stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("数据库查询失败", e);
        }
    }

    @Override
    public int getUserById(String userId) {
        String sql = "SELECT COUNT(*) AS total FROM user WHERE userId = ?"; // 使用别名
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("数据库查询失败", e);
        }
    }

    @Override
    public User getUserByIdByPass(String userId, String password) {
        String sql = "SELECT * FROM user WHERE userId = ? AND password = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setUserSex(rs.getInt("userSex"));
                user.setUserImg(rs.getString("userImg"));
                user.setDelTag(rs.getInt("delTag"));
                return user;
            }
        } catch (Exception e) {
            throw new RuntimeException("数据库查询失败", e);
        }
        return null;
    }
}

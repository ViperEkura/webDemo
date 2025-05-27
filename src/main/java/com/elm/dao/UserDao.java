package com.elm.dao;

import com.elm.entity.User;

public interface UserDao {
    int saveUser(User user);
    int getUserById(String userId);
    User getUserByIdByPass(String userId, String password);
}
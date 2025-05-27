package com.elm.service;
import com.elm.entity.User;

public interface UserService {
    int saveUser(User user);
    int getUserById(String userId);
    User getUserByIdByPass(String userId, String password);
}
package com.elm.service.impl;


import com.elm.dao.UserDao;
import com.elm.dao.impl.UserDaoImpl;
import com.elm.entity.User;
import com.elm.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
    @Override
    public int getUserById(String userId) {
        return userDao.getUserById(userId);
    }
    @Override
    public User getUserByIdByPass(String userId, String password) {
        return userDao.getUserByIdByPass(userId, password);
    }
}
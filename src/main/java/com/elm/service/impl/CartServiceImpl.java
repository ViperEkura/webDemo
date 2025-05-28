package com.elm.service.impl;

import com.elm.dao.CartDao;
import com.elm.dao.impl.CartDaoImpl;
import com.elm.entity.Cart;
import com.elm.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();
    @Override
    public List<Cart> listCartByUserId(String userId) {
        return cartDao.listCartByUserId(userId);
    }

    @Override
    public int saveCart(Cart cart) {
        return cartDao.saveCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }

    @Override
    public int removeCart(Cart cart) {
        return  cartDao.removeCart(cart);
    }
}

package com.elm.dao;

import com.elm.entity.Cart;

import java.util.List;

public interface CartDao {
    List<Cart> listCartByUserId(String userId);
    int saveCart(Cart cart);
    int updateCart(Cart cart);
    int removeCart(Cart cart);
}

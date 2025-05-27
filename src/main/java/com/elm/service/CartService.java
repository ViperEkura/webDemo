package com.elm.service;

import com.elm.entity.Cart;
import java.util.List;

public interface CartService {
    List<Cart> listCartByUserId(Integer userId);
    int saveCart(Cart cart);
    int updateCart(Cart cart);
    int removeCart(Cart cart);
}

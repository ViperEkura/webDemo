package com.elm.controller;


import com.elm.entity.Cart;
import com.elm.service.CartService;
import com.elm.service.impl.CartServiceImpl;
import com.elm.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/CartController/*")
public class CartServlet extends HttpServlet {
    private final CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getPathInfo();
        PrintWriter out = resp.getWriter();

        if (action.equals("/listCart")){
            String userId = req.getParameter("userId");
            List<Cart> cartList =  cartService.listCartByUserId(Integer.parseInt(userId));
            out.println(JsonUtil.toJson(cartList));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getPathInfo();
        PrintWriter out = resp.getWriter();

        switch (action){
            case "/saveCart" -> {
                Cart cart = JsonUtil.fromJson(req.getReader(), Cart.class);
                int result = cartService.saveCart(cart);
                out.println(JsonUtil.toJson(result));
            }
            case "/updateCart" -> {
                Cart cart = JsonUtil.fromJson(req.getReader(), Cart.class);
                int result = cartService.updateCart(cart);
                out.println(JsonUtil.toJson(result));
            }
            case  "/removeCart" -> {
                Cart cart = JsonUtil.fromJson(req.getReader(), Cart.class);
                int result = cartService.removeCart(cart);
                out.println(JsonUtil.toJson(result));
            }
            default -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}

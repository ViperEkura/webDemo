package com.elm.controller;

import com.elm.entity.DeliveryAddress;
import com.elm.service.DeliveryAddressService;
import com.elm.service.impl.DeliveryAddressServiceImpl;
import com.elm.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/DeliveryAddressController/*")
public class DeliveryAddressServlet extends HttpServlet {
    private final DeliveryAddressService service = new DeliveryAddressServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String action = req.getPathInfo();
            PrintWriter out = resp.getWriter();
            switch (action){
                case  "/saveDeliveryAddress" -> {
                    DeliveryAddress address = new DeliveryAddress();
                    address.setUserId(req.getParameter("userId"));
                    address.setContactName(req.getParameter("contactName"));
                    address.setContactSex(Integer.parseInt(req.getParameter("contactSex")));
                    address.setContactTel(req.getParameter("contactTel"));
                    address.setAddress(req.getParameter("address"));
                    int result = service.saveDeliveryAddress(address);
                    out.println(JsonUtil.toJson(result));
                }
                case  "/updateDeliveryAddress" -> {
                    //TODO
                }
                case "/listDeliveryAddressByUserId" ->{
                    String userId = req.getParameter("userId");
                    List<DeliveryAddress> adressList = service.listDeliveryAddressByUserId(userId);
                    out.println(JsonUtil.toJson(adressList));
                }
                case "/getDeliveryAddressById" -> {
                    Integer daId = Integer.parseInt(req.getParameter("daId"));
                    DeliveryAddress deliveryAddress = service.getDeliveryAddressById(daId);
                    out.println(JsonUtil.toJson(deliveryAddress));
                }
                default ->  resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

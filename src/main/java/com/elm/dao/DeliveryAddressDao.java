package com.elm.dao;

import com.elm.entity.DeliveryAddress;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAddressDao {
    List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
    int saveDeliveryAddress(DeliveryAddress address);
    DeliveryAddress getDeliveryAddressById(Integer daId);
}

package com.elm.service;

import com.elm.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

    int saveDeliveryAddress(DeliveryAddress address);

    DeliveryAddress getDeliveryAddressById(Integer daId);
}

package com.elm.service;

import com.elm.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    List<DeliveryAddress> istDeliveryAddressByUserId(String userId);
}

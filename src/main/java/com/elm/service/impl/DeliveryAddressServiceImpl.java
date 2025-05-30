package com.elm.service.impl;

import com.elm.dao.DeliveryAddressDao;
import com.elm.dao.impl.DeliveryAddressDapImpl;
import com.elm.entity.DeliveryAddress;
import com.elm.service.DeliveryAddressService;

import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    DeliveryAddressDao deliveryAddressDao = new DeliveryAddressDapImpl();
    public  List<DeliveryAddress> listDeliveryAddressByUserId(String userId){
        return  deliveryAddressDao.listDeliveryAddressByUserId(userId);
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress address) {
        return deliveryAddressDao.saveDeliveryAddress(address);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return deliveryAddressDao.getDeliveryAddressById(daId);
    }

}

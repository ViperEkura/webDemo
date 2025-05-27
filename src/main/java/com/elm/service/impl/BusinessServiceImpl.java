package com.elm.service.impl;

import com.elm.entity.Business;
import com.elm.dao.BusinessDao;
import com.elm.dao.impl.BusinessDaoImpl;
import com.elm.service.BusinessService;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private final BusinessDao businessDao = new BusinessDaoImpl();

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessDao.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return businessDao.getBusinessById(businessId);
    }
}

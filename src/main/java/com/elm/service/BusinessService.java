package com.elm.service;

import com.elm.entity.Business;
import java.util.List;


public interface BusinessService {

    List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    Business getBusinessById(Integer businessId);
}
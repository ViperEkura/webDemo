package com.elm.dao;

import com.elm.entity.Business;
import java.util.List;

public interface BusinessDao {
    List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    Business getBusinessById(Integer businessId);

}

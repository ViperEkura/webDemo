package com.elm.service.impl;

import com.elm.dao.FoodDao;
import com.elm.dao.impl.FoodDaoImpl;
import com.elm.entity.Food;
import com.elm.service.FoodService;

import java.util.List;

public class FoodServiceImpl implements FoodService {
    FoodDao foodDao = new FoodDaoImpl();
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodDao.listFoodByBusinessId(businessId);
    }
}

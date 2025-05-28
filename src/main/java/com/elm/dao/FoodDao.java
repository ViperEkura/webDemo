package com.elm.dao;

import com.elm.entity.Food;

import java.util.List;

public interface FoodDao {
    List<Food> listFoodByBusinessId(Integer businessId);
}

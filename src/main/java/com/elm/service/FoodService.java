package com.elm.service;

import com.elm.entity.Food;
import java.util.List;

public interface FoodService {
    List<Food> listFoodByBusinessId(Integer businessId);

}

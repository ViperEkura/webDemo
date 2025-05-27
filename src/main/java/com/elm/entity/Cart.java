package com.elm.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private Integer cartId;
    private Integer foodId;
    private Integer businessId;
    private String userId;
    private Integer quantity;

    private Food food;
    private Business business;
}

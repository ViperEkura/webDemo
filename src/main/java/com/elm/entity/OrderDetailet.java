package com.elm.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailet {
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
    private Food food;
}
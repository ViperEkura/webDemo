package com.elm.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private Double foodPrice;
    private Integer businessId;
    private String remarks;
}


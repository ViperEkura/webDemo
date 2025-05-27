package com.elm.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Business {
    private Integer businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;
    private Double starPrice;
    private Double deliveryPrice;
    private String remarks;
}

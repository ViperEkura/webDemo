package com.elm.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class DeliveryAddress {
    private Integer daId;
    private String contactName;
    private Integer contactSex;
    private String contactTel;
    private String address;
    private String userId;
}


package com.elm.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userId;
    private String password;
    private String userName;
    private Integer userSex;
    private String userImg;
    private Integer delTag;

}
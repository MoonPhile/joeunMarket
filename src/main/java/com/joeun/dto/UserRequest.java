package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private int userId; //유저 아이디 pk
    private String userUseId;   //유저 스트링 아이디
    private String userPw;
    private String userAddress;
    private String userPhone;
    private String userEmail;
}

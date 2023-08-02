package com.joeun.dto;

import lombok.Getter;

@Getter
public class UserResponse {
    private int userId; //유저 아이디 pk
    private String userUseId;   //유저 스트링 아이디
    private String userPw;
    private String userAddress;
    private String userPhone;
    private String userEmail;
}

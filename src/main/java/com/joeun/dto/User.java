package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String id;
    private String password;
    private String address;
    private String phone;
    private String email;

    public User(){}

    public User(String id, String password, String address, String phone, String email){
        this.id = id;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}

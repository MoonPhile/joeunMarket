package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private String id;
    private String password;
    private String name;
    private String phone;
    private Date date;

    public User(String id, String password, String name, String phone, Date date){
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.date = date;
    }
}

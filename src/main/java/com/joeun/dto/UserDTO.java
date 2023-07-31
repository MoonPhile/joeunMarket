package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class UserDTO {

    private String id;
    private String password;
    private String address;
    private String phone;
    private String email;

    public UserDTO(){}

    public UserDTO(String id, String password, String address, String phone, String email){
        this.id = id;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}

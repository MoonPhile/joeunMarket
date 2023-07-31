package com.joeun;

import com.joeun.dto.UserResponse;
import com.joeun.mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    void findAllUser(){
        List<UserResponse> userResponses = adminMapper.findAllUser();
        for(UserResponse user:userResponses){
            System.out.println("ID : "+user.getUserId());
            System.out.println("UsedId : "+user.getUserUseId());
            System.out.println("Pw : "+user.getUserPw());
            System.out.println("Address : "+user.getUserAddress());
            System.out.println("Email : "+user.getUserEmail());
            System.out.println("Phone : "+user.getUserPhone());
            System.out.println();
        }
    }
}

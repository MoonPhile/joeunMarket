package com.joeun;

import com.joeun.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserService userService;

//    @Test
//    void save11(){
//        String id = "a";
//        String password = "a";
//        String address = "a";
//        String phone = "a";
//        String email = "a";
//        this.userService.create();
//    }

    @Test
    void select(){
        String id = "희제이";
        this.userService.getUser(id);
    }
}

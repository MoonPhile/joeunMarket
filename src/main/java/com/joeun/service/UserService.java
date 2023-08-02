package com.joeun.service;

import com.joeun.dto.User;
import com.joeun.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public User create(String id, String password, String address, String phone, String email){
        User user = new User();
        user.setId(id);
        user.setPassword(passwordEncoder.encode(password));
//        user.setPassword(password);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);
        this.userMapper.insertUser(user);
        return user;
    }

//    public void signup(User user) throws Exception{
//        if (userMapper.insertUser(user) == 0){
//            throw new Exception("회원가입 실패");
//        }
//    }

}

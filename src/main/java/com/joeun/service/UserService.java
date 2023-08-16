package com.joeun.service;

import com.joeun.dto.User;
import com.joeun.form.UserCreateForm;
import com.joeun.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public User create(UserCreateForm userCreateForm) {
        User user = new User();
        user.setUserUseId(userCreateForm.getId());
        user.setUserPw(passwordEncoder.encode(userCreateForm.getPassword1()));
        user.setUserAddress(userCreateForm.getAddress());
        user.setUserPhone(userCreateForm.getPhone());
        user.setUserEmail(userCreateForm.getEmail());
        this.userMapper.insertUser(user);
        return user;
    }

    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    public void updateUser(User user) {
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));
        userMapper.updateUser(user);
    }

    public int getUserIntId(String userUseId){
        return userMapper.getUserIntId(userUseId);
    }
//    public User getUser(String id){
//        Optional<User> user = this.userMapper.selectById(id);
//        if(user.isPresent()){
//            return user.get();
//        }else{
//            throw new DataNotFoundException("user not found");
//        }
//    }
}


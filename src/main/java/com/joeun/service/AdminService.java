package com.joeun.service;

import com.joeun.dto.User;
import com.joeun.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper adminMapper;

    public List<User> findAllUser(){
        return adminMapper.findAllUser();
    }

}

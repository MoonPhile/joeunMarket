package com.joeun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joeun.dto.UserResponse;
import com.joeun.mapper.AdminMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper adminMapper;

    public List<UserResponse> findAllUser(){
        return adminMapper.findAllUser();
    }

}

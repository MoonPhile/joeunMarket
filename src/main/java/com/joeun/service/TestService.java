package com.joeun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joeun.dto.TestResponse;
import com.joeun.mapper.TestMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestMapper testMapper;

    public List<TestResponse> findAll(){
        return testMapper.findAll();
    }
}

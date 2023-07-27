package com.joeun.service;

import com.joeun.dto.TestResponse;
import com.joeun.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestMapper testMapper;

    public List<TestResponse> findAll(){
        return testMapper.findAll();
    }
}

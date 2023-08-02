package com.joeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.dto.ProductDto;
import com.joeun.mapper.ProductMapper;

@Service
public class ItemService {

    private final ProductMapper productMapper;

    // ItemMapper를 주입받는 생성자
    @Autowired
    public ItemService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    // 아이템 목록 조회
    public List<ProductDto> findAll() {
        return productMapper.findAll();
    }

   
}
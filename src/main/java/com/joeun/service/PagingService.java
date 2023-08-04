package com.joeun.service;

import org.springframework.stereotype.Service;

import com.joeun.mapper.PagingMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagingService {
	
	//본인의 mapper 선언
	private final PagingMapper pagingMapper; 

	//countAll??(본인이 검색할 table)
	public int countAllProducts() {
		return pagingMapper.countAllProducts();
	}
	
	public int countProductsByKeyword(String keyword) {
		return pagingMapper.countProductsByKeyword(keyword);
	}
}

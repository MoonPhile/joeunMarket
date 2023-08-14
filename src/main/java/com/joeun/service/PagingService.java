package com.joeun.service;

import com.joeun.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import com.joeun.mapper.PagingMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagingService {

	//본인의 mapper 선언
	private final PagingMapper pagingMapper;
	private final CommentMapper commentMapper;

	//countAll??(본인이 검색할 table)
	public int countAllProducts() {
		return pagingMapper.countAllProducts();
	}

	public int countProductsByKeyword(String keyword) {
		return pagingMapper.countProductsByKeyword(keyword);
	}

	public int countProductscategory(int category) {
		return pagingMapper.countProductscategory(category);

	}
	public int countAllPost() {
		return pagingMapper.countAllPost();
	}

}

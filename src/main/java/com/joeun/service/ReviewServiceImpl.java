package com.joeun.service;

import com.joeun.dto.ReviewDto;
import com.joeun.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //서비스선언
public class ReviewServiceImpl implements ReviewService {
    @Autowired //Mapper와 연결
    private ReviewMapper reviewMapper;

    @Override
    public List<ReviewDto> selectReviewList() throws Exception {

        return reviewMapper.selectReviewList();

    }

    @Override
    public void insertReview(ReviewDto review) throws Exception {
        reviewMapper.insertReview(review);
    }
}
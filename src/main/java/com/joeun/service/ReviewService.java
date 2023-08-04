package com.joeun.service;

import com.joeun.dto.ReviewDto;
import com.joeun.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //서비스선언
@RequiredArgsConstructor
public class ReviewService {

    final private ReviewMapper reviewMapper;

    public List<ReviewDto> selectReviewList() throws Exception {

        return reviewMapper.selectReviewList();

    }

    public void insertReview(ReviewDto review) throws Exception {
        reviewMapper.insertReview(review);
    }
}
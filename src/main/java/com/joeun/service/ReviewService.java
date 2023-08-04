package com.joeun.service;

import com.joeun.dto.ReviewDto;
import com.joeun.mapper.ReviewMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public interface ReviewService {

    List<ReviewDto> selectReviewList() throws Exception;

 void insertReview(ReviewDto review) throws Exception;

}

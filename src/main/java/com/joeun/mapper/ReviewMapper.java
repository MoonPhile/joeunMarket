package com.joeun.mapper;

import com.joeun.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // Mapper 선언
public interface ReviewMapper {
    List<ReviewDto> selectReviewList() throws Exception;

    void insertReview(ReviewDto review) throws Exception;

}

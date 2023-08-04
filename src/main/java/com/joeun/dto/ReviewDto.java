package com.joeun.dto;

import lombok.Data;

import java.util.Date;

@Data // Lombok을 사용하기 때문에 getter setter 안적어줘도 됨
public class ReviewDto {

    private int reviewId;
    private String reviewTitle;
    private Date reviewDate;
    private String reviewContent;
    private int reviewRate;
    private int productId;

}

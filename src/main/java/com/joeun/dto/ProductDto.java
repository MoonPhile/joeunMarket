package com.joeun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int productId;
    private String productName;
    private String productCondition;
    private int productPrice;
    private String productDescription;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private int productCategoryId;

}

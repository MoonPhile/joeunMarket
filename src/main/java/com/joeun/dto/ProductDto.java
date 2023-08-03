package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int productId;
    private String productName;
    private String productCondition;
    private int productPrice;
    private String productDescription;
    private String[] imgs;
    private int productCategoryId;

}

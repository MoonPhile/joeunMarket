package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

    private int cartId;

    private String userId;

    private int productId;

    private int productCnt;

    //수정해야함!! 여기서부터 완전히!!!!
    private String productNm;
    private int productPrice;
    private double productDiscount;

    public void initSaleTotal() {
        this.salePrice = (int) (this.productPrice * (1-this.productDiscount));
        this.totalPrice = this.salePrice*this.productCnt;
    }

    // 추가
    private int salePrice;

    private int totalPrice;


}

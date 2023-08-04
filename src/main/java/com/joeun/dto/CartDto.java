package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

    //Cart 테이블
    private int cartId;
    private int cartUserId;
    private int cartProductId;
    private int cartProductCnt;




// cart 테이블과 조인하기 위해 변수값 장바구니 페이지에 뿌려주려고 추가함
    private String productName;
    private int productPrice;


//    public void initSaleTotal() {
//        this.salePrice = (int) (this.productPrice * (1-this.productDiscount));
//        this.totalPrice = this.salePrice*this.productCnt;
//    }
//
//    // 추가
//    private int salePrice;
//
//    private int totalPrice;


}

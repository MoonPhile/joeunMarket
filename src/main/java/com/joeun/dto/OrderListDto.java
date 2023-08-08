package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderListDto {
    private int listListId;
    private int listOrderId;
    private int listProductId;
    private String listRefund;

    // 모든 필드를 포함하는 생성자 추가
    public OrderListDto(int listListId, int listOrderId, int listProductId, String listRefund) {
        this.listListId = listListId;
        this.listOrderId = listOrderId;
        this.listProductId = listProductId;
        this.listRefund = listRefund;
    }
}

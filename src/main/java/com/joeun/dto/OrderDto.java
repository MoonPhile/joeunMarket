package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDto {

    /* 만들어 낼 값 */
    private int ordersId;
    private int orderUser;
    private int orderProduct;
    private Date ordersDate;

    public void setOrderDate(Date date) {
        this.ordersDate = date;
    }

    // product 관련
    private String productInfo;

}

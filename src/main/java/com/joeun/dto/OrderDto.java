package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDto {

    /* 만들어 낼 값 */
    private int orderId;
    private int orderUserId;
    private int orderProductId;
    private Date orderDate;

    public void setOrderDate(Date date) {
        this.orderDate = date;
    }
}

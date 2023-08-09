package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDto {

    /* 만들어 낼 값 */
    private int orders_id;
    private int user_id;
    private int product_id;
    private Date orders_date;

    public void setOrderDate(Date date) {
        this.orders_date = date;
    }

    // product 관련
    private String productInfo;

}

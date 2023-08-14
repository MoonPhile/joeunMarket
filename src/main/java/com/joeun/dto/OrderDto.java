package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class OrderDto {

    /* 만들어 낼 값 */
    private int ordersId;
    private String userUseId;
    private int productId;
    private Date ordersDate;

    /* 주문 처리 Dto 추가 */
    private String ordersName;
    private String ordersPhone;
    private String ordersAddress;

    /* 취소처리 Dto 추가*/
    private String ordersStatus;
    private Date ordersCanceltimes;

    public void setOrderDate(Date date) {
        this.ordersDate = date;
    }

    /* product 관련*/
    private String productName;
    private String productDescription;
    private int productPrice;

    @Override
    public String toString() {
        return "OrderDto{" +
                "ordersId=" + ordersId +
                ", userUseId='" + userUseId + '\'' +
                ", productId=" + productId +
                ", ordersDate=" + ordersDate +
                ", ordersName='" + ordersName + '\'' +
                ", ordersPhone='" + ordersPhone + '\'' +
                ", ordersAddress='" + ordersAddress + '\'' +
                ", ordersStatus='" + ordersStatus + '\'' +
                ", ordersCanceltimes=" + ordersCanceltimes +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }


}
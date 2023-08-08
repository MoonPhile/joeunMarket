package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Payment {
    private int paymentId;
    private int userId;
    private int orderId;
    private Date paymentDate;
    private String impUid;      //실제 결제 정보를 가진 uid portone에서 제공
}

package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PaymentInfo {
    private int paymentId;
    private int userId;
    private int orderId;
    private Date paymentDate;
}

package com.joeun.service;

import com.joeun.dto.Payment;
import com.joeun.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public void insertPayment(Payment payment) {
        System.out.println("인서트 페이먼트 실행");
        paymentMapper.insertPayment(payment);
    }

}

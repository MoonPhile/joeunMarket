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
        paymentMapper.insertPayment(payment);
    }

}

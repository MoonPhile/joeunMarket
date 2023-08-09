package com.joeun.mapper;

import com.joeun.dto.Payment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.http.Query;

import java.util.List;

@Mapper
public interface PaymentMapper {

    void insertPayment(Payment payment);

    void deletePayment(int id);

    Payment findPaymentById(int id);

    List<Payment> findAllPayment();
}

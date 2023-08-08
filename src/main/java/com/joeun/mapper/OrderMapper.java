package com.joeun.mapper;

import com.joeun.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insertOrder(OrderDto order);

    List<OrderDto> getAllOrders(); // 주문 목록을 조회하는 메서드

    // 추가적인 메서드 정의
}
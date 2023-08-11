package com.joeun.service;

import com.joeun.dto.OrderDto;
import com.joeun.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class OrderService {
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void placeOrder(OrderDto orderDto,String ordersName, String ordersPhone, String ordersAddress) {
        orderDto.setUserUseId(orderDto.getUserUseId()); // 이 부분 삭제해주세요
        orderDto.setProductId(orderDto.getProductId());
        orderDto.setOrderDate(new Date());

        orderDto.setOrdersName(ordersName);
        orderDto.setOrdersPhone(ordersPhone);
        orderDto.setOrdersAddress(ordersAddress);

        orderMapper.saveOrder(orderDto);
    }

    public List<OrderDto> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    // 주문 출력
    public List<OrderDto> getOrdersWithProductInfoByUserId(String userId) {
        return orderMapper.getOrdersWithProductInfoByUserId(userId);
    }
}



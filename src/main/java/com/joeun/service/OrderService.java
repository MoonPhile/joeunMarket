package com.joeun.service;

import com.joeun.dto.OrderDto;
import com.joeun.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
        private final OrderMapper orderMapper;

        @Autowired
        public OrderService(OrderMapper orderMapper) {
            this.orderMapper = orderMapper;
        }

        public void placeOrder(OrderDto order) {
            orderMapper.insertOrder(order);
        }

        public List<OrderDto> getAllOrders() {
            return orderMapper.getAllOrders();
        }

        // 추가적인 메서드 정의
    }
package com.joeun.service;

import com.joeun.dto.OrderDto;
import com.joeun.dto.ProductDto;
import com.joeun.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void placeOrder(OrderDto orderDto) {
        orderMapper.saveOrder(orderDto);
    }


    public List<OrderDto> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    public List<ProductDto> getAllProducts(){
        return orderMapper.getAllProducts();
    }

    // 주문 출력
    public List<OrderDto> getOrdersWithProductInfoByUserId(String userId) {
        return orderMapper.getOrdersWithProductInfoByUserId(userId);
    }

    public OrderDto findOrderById(String userId, int productId) {
        return orderMapper.findOrderById(userId, productId);
    }




    }





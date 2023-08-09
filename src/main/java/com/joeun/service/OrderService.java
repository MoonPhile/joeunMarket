package com.joeun.service;

import com.joeun.dto.OrderDto;
import com.joeun.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;


    public void placeOrder(OrderDto orderDto) {
        OrderDto orders = new OrderDto();
        orders.setUserId(orderDto.getUserId());
        orders.setProductId(orderDto.getProductId());
        orders.setOrderDate(new Date());

        // OrderDto를 사용하여 Mapper를 통해 데이터베이스에 주문 정보 저장
        orderMapper.saveOrder(orders);
    }

    public List<OrderDto> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    public OrderDto findOrderById(int productId,int userId) {
        System.out.println("productId와 userId로 order의 정보를 가져옵니다.");
        return orderMapper.findOrderById(productId,userId);
    }
}




package com.joeun.service;

import com.joeun.dto.OrderDto;
import com.joeun.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    //Autowired -> @RequiredArgsConstructor 대체 했습니다.

    public void placeOrder(OrderDto orderDto,String ordersName, String ordersPhone, String ordersAddress) {
        OrderDto orders = new OrderDto();
        orders.setUserId(orderDto.getUserId());
        orders.setProductId(orderDto.getProductId());
        orders.setOrderDate(new Date());

        orderDto.setOrdersName(ordersName);
        orderDto.setOrdersPhone(ordersPhone);
        orderDto.setOrdersAddress(ordersAddress);

        orderMapper.saveOrder(orderDto);
    }


    public List<OrderDto> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    // 주문 출력
    public List<OrderDto> getOrdersWithProductInfoByUserId(int userId) {
        return orderMapper.getOrdersWithProductInfoByUserId(userId);
    }


}




package com.joeun.service;

import com.joeun.dto.OrderListDto;
import com.joeun.mapper.OrderListMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {

    private final OrderListMapper orderListMapper;

    // 생성자 주입을 사용하여 OrderListMapper를 주입받음
    public OrderListServiceImpl(OrderListMapper orderListMapper) {
        this.orderListMapper = orderListMapper;
    }

    @Override
    public List<OrderListDto> getAllOrderLists() {
        return orderListMapper.getAllOrderLists();
    }
}
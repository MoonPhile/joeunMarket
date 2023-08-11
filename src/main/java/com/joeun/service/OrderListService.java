package com.joeun.service;

import com.joeun.dto.OrderListDto;

import java.util.List;

public interface OrderListService {
    List<OrderListDto> getAllOrderLists();
}
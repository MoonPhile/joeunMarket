package com.joeun.mapper;


import com.joeun.dto.OrderDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
//    void insertOrder(OrderDto orderDto);
    void saveOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

}
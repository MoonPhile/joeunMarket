package com.joeun.mapper;


import com.joeun.dto.OrderDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    void saveOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();
    List<OrderDto> getOrdersWithProductInfoByUserId(@Param("userId") int userId);
    void cancelOrder(@Param("orderId") int orderId, @Param("cancelReason") String cancelReason);

    OrderDto getOrderById(@Param("orderId") int orderId);

    void updateOrder(OrderDto orderDto);

}
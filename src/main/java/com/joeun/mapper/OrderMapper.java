package com.joeun.mapper;


import com.joeun.dto.OrderDto;
import com.joeun.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    void saveOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

   List<OrderDto> getOrdersByUserId(@Param("userId") int userId);

    List<OrderDto> getOrdersWithProductInfoByUserId(@Param("userUseId") String userUseId);

    OrderDto findOrderById(@Param("userId") String userId,@Param("productId") int productId);


    List<ProductDto> getAllProducts();

}

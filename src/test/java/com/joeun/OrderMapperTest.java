package com.joeun;


import com.joeun.dto.OrderDto;
import com.joeun.dto.PostRequest;
import com.joeun.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSaveOrder() {
        OrderDto order = new OrderDto();
        order.setUserId(1); // 예시 사용자 ID
        order.setProductId(123); // 예시 상품 ID
        order.setOrderDate(new Date());

        orderMapper.saveOrder(order);

    }
}

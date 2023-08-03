package com.joeun;


import com.joeun.dto.CartDto;
import com.joeun.mapper.CartMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CartMapperTest {
    @Autowired
    private CartMapper mapper;

    @Test
    public void addCart() {
        String userId = "admin";
        int productId = 61;
        int count = 2;

        CartDto cart = new CartDto();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setProductCnt(count);

        int result = 0;
        result = mapper.addCart(cart);

        System.out.println("결과 : " + result);

    }


    /* 카트 삭제 */

    @Test
    public void deleteCartTest() {
        int cartId = 1;

        mapper.deleteCart(cartId);
    }


    /* 카트 수량 수정 */

    @Test
    public void modifyCartTest() {
        int cartId = 3;
        int count = 5;

        CartDto cart = new CartDto();
        cart.setCartId(cartId);
        cart.setProductCnt(count);
        mapper.modifyCount(cart);

    }


    /* 카트 목록 */
    @Test
    public void getCartTest() {
        String userId = "admin";
        List<CartDto> list = mapper.getCart(userId);
        for(CartDto cart : list) {
            System.out.println(cart);
            cart.initSaleTotal();
            System.out.println("init cart : " + cart);
        }
    }

    /* 카트 확인 */

    @Test
    public void checkCartTest() {

        String userId = "admin";
        int productId = 71;

        CartDto cart = new CartDto();
        cart.setUserId(userId);
        cart.setProductId(productId);

        CartDto resutlCart = mapper.checkCart(cart);
        System.out.println("결과 : " + resutlCart);

    }
}

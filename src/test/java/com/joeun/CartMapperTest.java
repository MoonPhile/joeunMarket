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
    CartMapper mapper;

    @Test
    public void addCart() {
        int cartUserId = 1;
        int cartProductId = 1;
        int count = 2;

        CartDto cart = new CartDto();
        cart.setCartUserId(cartUserId);
        cart.setCartProductId(cartProductId);
        cart.setCartProductCnt(count);
        int result = 0;
        result = mapper.addCart(cart);
        System.out.println(cart);

    }


    /* 카트 삭제 */

    @Test
    public void deleteCartTest() {
        int cartId = 12;
        mapper.deleteCart(cartId);
    }


    /* 카트 수량 수정 */

    @Test
    public void modifyCartTest() {
        int cartId = 3;
        int count = 5;

        CartDto cart = new CartDto();
        cart.setCartId(cartId);
        cart.setCartProductCnt(count);
        mapper.modifyCount(cart);

    }


    /* 카트 목록 */
    @Test
    public void getCartTest() {
        int cartUserId = 3;
        List<CartDto> list = mapper.getCart(cartUserId);
        for(CartDto cart : list) {
            System.out.println(cart);
            System.out.println("init cart : " + cart);
        }
    }

    /* 카트 확인 */

    @Test
    public void checkCartTest() {
        int cartUserId = 10;
        int cartProductId = 71;

        CartDto cart = new CartDto();
        cart.setCartUserId(cartUserId);
        cart.setCartProductId(cartProductId);

        CartDto resutlCart = mapper.checkCart(cart);
        System.out.println("결과 : " + resutlCart);

    }
}

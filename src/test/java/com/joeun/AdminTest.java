package com.joeun;

import com.joeun.dto.Payment;
import com.joeun.dto.ProductDto;
import com.joeun.mapper.AdminMapper;
import com.joeun.service.MailService;
import com.joeun.service.PaymentService;
import com.joeun.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminTest {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    MailService mailService;

    @Autowired
    ProductService productService;

    @Autowired
    PaymentService paymentService;

    @Test
    void listTest(){
        List<ProductDto> productList = productService.findAllProduct();
        for(ProductDto product:productList){
            System.out.println(product.getProductName());
            System.out.println(product.getImg1());
            System.out.println(product.getImg2());
            System.out.println(product.getImg3());
            System.out.println(product.getImg4());
            System.out.println();
        }
    }

    @Test
    void findIdTest(){
        List<Integer> idList = productService.findAllProductId();
        for(int i: idList){
            System.out.println(i);
        }
    }

    @Test
    void findById(){
        ProductDto productDto = productService.findProductById(1);
        System.out.println(productDto.getProductName());
    }

    @Test
    void insertPayment(){
        Payment payment = new Payment();
        payment.setUserId(1);
        payment.setOrderId(1);
        payment.setPaymentPrice(4500);
        payment.setImpUid("imptest_1234");

        paymentService.insertPayment(payment);
    }

    @Test
    void payCancel(){
        String accessToken = paymentService.getAccessToken();
        String imp_uid = "imp_464112159962";
        paymentService.payCancel(accessToken,imp_uid);
    }
}

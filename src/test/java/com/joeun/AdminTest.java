package com.joeun;

import com.joeun.dto.ProductDto;
import com.joeun.mapper.AdminMapper;
import com.joeun.service.MailService;
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
}

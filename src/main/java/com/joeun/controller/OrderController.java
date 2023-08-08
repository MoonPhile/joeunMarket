package com.joeun.controller;

import com.joeun.dto.OrderDto;
import com.joeun.dto.ProductDto;
import com.joeun.service.OrderService;
import com.joeun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class OrderController {
    private final OrderService orderService; // OrderService 주입
    private final ProductService productService;
    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/order")
    public String showOrderPage(Model model) {

        // 출력 확인용
        int productId = 1;

        ProductDto productDto = productService.getProductInfo(productId); // 상품 정보 가져오기

        // 주문 정보에 필요한 추가 정보 설정
        productDto.setProductOrderUserId(1);
        productDto.setProductOrderDate(new Date());

        // 모델에 ProductDto 객체 추가
        model.addAttribute("productDto", productDto);

        return "order";
    }

    // 상품 상세 정보 가져온 후, 주문 페이지로 전달.
    @GetMapping("/order/{productId}")
    public String getOrderPage(@PathVariable int productId, Model model) {
        ProductDto product = productService.getProductInfo(productId);
        model.addAttribute("product", product);
        return "order";
    }

    // 주문 완료
    @PostMapping("/completeOrder")
    public String completeOrder(@ModelAttribute OrderDto order) {
        orderService.placeOrder(order);
        return "order_complete";
    }
}
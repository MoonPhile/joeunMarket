package com.joeun.controller;

import com.joeun.dto.OrderDto;
import com.joeun.dto.ProductDto;
import com.joeun.dto.User;
import com.joeun.mapper.OrderMapper;
import com.joeun.service.OrderService;
import com.joeun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.joeun.mapper.UserMapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService; // OrderService 주입
    private final ProductService productService;
    private UserMapper userMapper;
    private OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService, UserMapper userMapper, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.productService = productService;
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/order")
    public String showOrderPage(@RequestParam(defaultValue = "1") int productId, Model model) {
        // 출력 확인용
        ProductDto productDto = productService.getProductInfo(productId); // 상품 정보 가져오기
        // 모델에 ProductDto 객체 추가
        model.addAttribute("productDto", productDto);

        return "order";
    }

    // 상품 상세 정보 가져온 후, 주문 페이지로 전달. (윤서)
    // 이 버튼을 누를시 로그인 시에만 가능하게 변경. 8/8 16:23 (진석)
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/order/{productId}")
    public String getOrderPage(@PathVariable int productId, Model model) {
        ProductDto product = productService.getProductInfo(productId);
        model.addAttribute("product", product);
        return "order";
    }

    // 주문 완료
    @PostMapping("/completeOrder")
    public String completeOrder(@ModelAttribute OrderDto order,
                                @RequestParam String ordersName,
                                @RequestParam String ordersPhone,
                                @RequestParam String ordersAddress,
                                @RequestParam(defaultValue = "1") int productId,
                                Authentication authentication,
                                Model model) {

        // 현재 로그인된 사용자의 아이디
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserId = userDetails.getUsername();

        // 로그인한 유저 정보를 이용하여 주문 정보 설정
        order.setUserId(Integer.parseInt(currentUserId)); // 사용자 아이디 설정
        order.setProductId(productId); // 상품 아이디 설정
        order.setOrderDate(new Date()); // 주문 날짜 설정

        orderService.placeOrder(order, ordersName, ordersPhone, ordersAddress);

        model.addAttribute("message", "주문이 완료되었습니다.");

        return "order_complete";
    }

    // 주문 내역
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/order-history")
    public String showOrderHistoryPage(Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserId = userDetails.getUsername();
        int userId = Integer.parseInt(currentUserId);

        List<OrderDto> orderHistory = orderService.getOrdersWithProductInfoByUserId(userId);
        model.addAttribute("orderHistory", orderHistory);

        return "order_history";
    }

}

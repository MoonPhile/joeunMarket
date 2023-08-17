package com.joeun.controller;

import com.joeun.dto.*;
import com.joeun.mapper.OrderMapper;
import com.joeun.service.OrderService;
import com.joeun.service.ProductService;
import com.joeun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.joeun.mapper.UserMapper;

import javax.persistence.criteria.Order;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService; // OrderService 주입
    private final ProductService productService;
    private final UserService userService;

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
                                @RequestParam(defaultValue = "1") int productId,
                                Authentication authentication,
                                String paymentMethod,
                                Model model) {
        System.out.println(paymentMethod);
        // 현재 로그인된 사용자의 아이디
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserId = userDetails.getUsername();

        // 로그인한 유저 정보를 이용하여 주문 정보 설정
        order.setUserUseId(currentUserId); // 사용자 아이디 설정
        order.setProductId(productId); // 상품 아이디 설정
        order.setOrderDate(new Date()); // 주문 날짜 설정

        System.out.println("order toString\n"+order.toString());

        orderService.placeOrder(order);
        //방금 저장된 order 정보를 불러옵니다.
        OrderDto orderDto = orderService.findOrderById(currentUserId,productId);
        ProductDto product = productService.findProductById(productId);
        int userId = userService.getUserIntId(currentUserId);
        model.addAttribute("order",orderDto);
        model.addAttribute("product",product);
        model.addAttribute("paymentMethod",paymentMethod);
        model.addAttribute("userId",userId);
        model.addAttribute("message", "주문이 완료되었습니다.");

        return "order_complete";
    }

    // 주문 내역
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/order-history")
    public String showOrderHistoryPage(Authentication authentication, Model model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserId = userDetails.getUsername();
        List<OrderDto> orderHistory = orderService.getOrdersWithProductInfoByUserId(currentUserId);
        List<OrderDto> orderCanceled = orderService.getCanceledwithProductInfoByUserId(currentUserId);
        model.addAttribute("orderHistory", orderHistory);
        model.addAttribute("orderCanceled", orderCanceled);
        return "order_history";
    }

    //어드민 주문 전체 조회
    @GetMapping("/orderList.do")
    public String getAllOrders(Model model){
        List<OrderDto> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/adminOrders";
    }


}




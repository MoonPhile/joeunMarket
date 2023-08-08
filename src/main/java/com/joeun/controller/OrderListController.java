package com.joeun.controller;

import com.joeun.dto.OrderListDto;
import com.joeun.service.OrderListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderListController {

    private final OrderListService orderListService;

    // 생성자 주입을 사용하여 OrderListService를 주입받음
    public OrderListController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    @GetMapping("/orderList")
    public String getOrderList(Model model) {
        // OrderListDto를 리스트로 받아와서 모델에 추가하여 orderlist.html로 전달
        List<OrderListDto> orderList = orderListService.getAllOrderLists();
        model.addAttribute("orderList", orderList);
        return "order_list";
    }
}
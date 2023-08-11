package com.joeun.controller;

import com.joeun.dto.Payment;
//import com.joeun.service.PaymentService;
import com.joeun.service.PaymentService;
import com.joeun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final ProductService productService;

    @PostMapping("/payment/validate")
    public String payValidate(@RequestBody Payment payment) {
        System.out.println("페이먼트 검증 컨트롤러 진입");
        System.out.println("paymentId(AI) " + payment.getPaymentId());
        System.out.println("userId " + payment.getUserId());
        System.out.println("orderId " + payment.getOrderId());
        System.out.println("paymentPrice: " + payment.getPaymentPrice());
        System.out.println("Date: NOW()");
        System.out.println("impUid: " + payment.getImpUid());
        //검증 로직 구현 필요
//        int price = productService.getPriceById(productId);
        //product의 가격과 payment의 price가 같을경우 결제 진행 및 insert
        //다를 경우엔 결제 취소
        //결제전에 검증하고 취소할수있으면 좋은데 방법 생각해봐야함
        try {
//            if (price == payment.getPaymentPrice()) {
                paymentService.insertPayment(payment);
//            } else {
//                doPayCancel(payment);
//            }

        } catch (Exception e) {
            e.printStackTrace();
            //결제 실패할경우
//        String accessToken = paymentService.getAccessToken();
//        paymentService.payCancel(accessToken,imp_uid);
        }
        //결제 완료 후 돌아갈 페이지
        return "";
    }

    @PostMapping("/payment/payCancel")
    @ResponseBody
    public String doPayCancel(@RequestParam int orderId) {
        System.out.println("결제 취소 진행");
        String accessToken = paymentService.getAccessToken();
        Payment payment = paymentService.findPaymentByOrderId(orderId);
        String impUid = payment.getImpUid();
        int paymentId = payment.getPaymentId();
        paymentService.payCancel(accessToken, impUid);
        paymentService.deletePayment(paymentId);

        return "redirect: order-history";
    }

    @GetMapping("/tossPay.do")
    public String goToToss(){
        return "/test/tossPayTest";
    }

}

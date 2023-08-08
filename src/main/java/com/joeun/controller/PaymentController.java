package com.joeun.controller;

import com.joeun.dto.Payment;
//import com.joeun.service.PaymentService;
import com.joeun.service.PaymentService;
import com.joeun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final ProductService productService;

    @GetMapping("/portOne.do")
    public String goToTestPay() {
        return "/test/portOne";
    }

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
//        productService.getPriceById(payment.)
        //product의 가격과 payment의 price가 같을경우 결제 진행 및 insert
        //다를 경우엔 결제 취소
        //결제전에 검증하고 취소할수있으면 좋은데 방법 생각해봐야함

        paymentService.insertPayment(payment);

        return "";
    }

//    @GetMapping("/token")
//    public ResponseEntity<String> getToken() throws IOException, JSONException {
//
//        final HttpURLConnection conn = getTokenConnection();
//
//        final JSONObject obj = getJsonObject();
//
//        sendRequest(conn, obj);
//
//        final int responseCode = getResponseCode(conn);
//
//        if (responseCode != 200) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        final BufferedReader br = new BufferedReader(
//                new InputStreamReader(conn.getInputStream()));
//
//        final String accessToken = getResponse(br);
//
//        disconnect(conn, br);
//        return ResponseEntity.ok(accessToken);
//    }

}

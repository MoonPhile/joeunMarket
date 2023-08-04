package com.joeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ShopController {

    // 메인페이지 ( 비로그인 유저 )
    @GetMapping("/")
    public String home(){
        return "main";
    }

    // 메인페이지 ( 로그인 유저 / 구현할게용 )
    @GetMapping("/main")
    public String main(){
        return "user/main";
    }


}
package com.joeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/admin")
    public String goToAdmin(Model model){
        model.addAttribute("data","모델 테스트입니다");
        return "/admin/adminMain";
    }
}

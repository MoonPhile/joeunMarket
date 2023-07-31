package com.joeun.controller;

import com.joeun.dto.UserResponse;
import com.joeun.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @GetMapping("/admin.do")
    public String goToAdmin(Model model){

        model.addAttribute("data","모델 테스트입니다");
        return "/admin/adminMain";
    }
    @GetMapping("/adminGetUserList")
    @ResponseBody
    public List<UserResponse> adminGetUserList(){
        System.out.println("회원정보 불러오기 실행");
        return adminService.findAllUser();
    }
}

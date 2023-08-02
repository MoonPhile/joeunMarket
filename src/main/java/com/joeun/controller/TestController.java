package com.joeun.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joeun.dto.TestResponse;
import com.joeun.service.TestService;

import lombok.RequiredArgsConstructor; 

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    
    @GetMapping("/test.do")
    String test(){
        return "test/test";
    }

    @GetMapping("/testView.do")
    String testView(Model model){
        List<TestResponse> list = testService.findAll();
        model.addAttribute("list",list);
        return "test/testView";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hiyoaaaa";
    }

    

}

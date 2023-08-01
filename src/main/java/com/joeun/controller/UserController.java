package com.joeun.controller;

import com.joeun.form.UserCreateForm;
import com.joeun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }

//    @GetMapping("/login")
//    public String signup(UserCreateForm userCreateForm){ return "signup_form";}

    @PostMapping("/login")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "login_form";
        }

        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2","passwordInCorrect",
                    "패스워드가 일치하지 않습니다.");
            return "login_form";
        }

        userService.create(userCreateForm.getId(),userCreateForm.getPassword1(), userCreateForm.getEmail(),
                userCreateForm.getPhone(), userCreateForm.getAddress());

        return "redirect:/";
    }

}

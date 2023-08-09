package com.joeun.controller;

import com.joeun.dto.User;
import com.joeun.form.UserCreateForm;
import com.joeun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(UserCreateForm userCreateForm){
        return "login_form";
    }

//    @GetMapping("/login")
//    public String signup(UserCreateForm userCreateForm){ return "signup_form";}

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "login_form";
        }

        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2","passwordInCorrect",
                    "패스워드가 일치하지 않습니다.");
            return "login_form";
        }

        try{
            userService.create(userCreateForm);
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed","이미 등록된 사용자 입니다.");
            return "login_form";
        }catch (Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed",e.getMessage());
            return "login_form";
        }

        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm() {
//        User users = userService.getUserById(id);
//        model.addAttribute("member", users);
//        model.addAttribute("loggedInUser", user); // 로그인한 사용자 정보 추가
        return "edituser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}

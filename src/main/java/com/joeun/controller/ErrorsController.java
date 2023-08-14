package com.joeun.controller;

import com.joeun.config.ErrorStatus;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorsController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                System.out.println("404 에러 발생 =? URI :" + request.getRequestURI());
                return "error/404";
            }else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()){
                System.out.println("405 에러 발생 =? URI :" + request.getMethod());
                return "error/405";
            }else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                System.out.println("500 에러 발생 =? URI :");
                return "error/500";
            }
        }
        String codeStr = request.getParameter("code");
        codeToReason(codeStr,model);
        return "error/404";
    }

    private void codeToReason(String codeStr, Model model){
        if(codeStr != null) {
            Integer code = Integer.valueOf(codeStr);
            if(code == ErrorStatus.NotFoundPost.getCode()){
                model.addAttribute("reason", ErrorStatus.NotFoundPost.getReason());
            }else if(code == ErrorStatus.NotAuthorize.getCode()){
                model.addAttribute("reason", ErrorStatus.NotAuthorize.getReason());
            }
        }
    }
}

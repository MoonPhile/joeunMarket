package com.joeun;

import com.joeun.dto.EmailMessage;
import com.joeun.dto.UserResponse;
import com.joeun.mapper.AdminMapper;
import com.joeun.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminTest {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    MailService mailService;

    @Test
    void findAllUser(){
        List<UserResponse> userResponses = adminMapper.findAllUser();
        for(UserResponse user:userResponses){
            System.out.println("ID : "+user.getUserId());
            System.out.println("UsedId : "+user.getUserUseId());
            System.out.println("Pw : "+user.getUserPw());
            System.out.println("Address : "+user.getUserAddress());
            System.out.println("Email : "+user.getUserEmail());
            System.out.println("Phone : "+user.getUserPhone());
            System.out.println();
        }
    }

    @Test
    void mailTest(){
        EmailMessage message = new EmailMessage();
        message.setTo("lunatic1702@gmail.com");
        message.setSubject("테스트 이메일입니다.");
        message.setMessage("메일 보내기 성공");
        mailService.sendMailReject(message);

    }
}

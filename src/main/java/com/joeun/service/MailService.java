package com.joeun.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.joeun.dto.EmailMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    @Async
    public boolean sendMailReject(String[] toArray,EmailMessage message){
        boolean msg = false;
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("joeunMarketTeam@gamil.com");
        simpleMailMessage.setTo(toArray);
        simpleMailMessage.setSubject(message.getSubject());
        simpleMailMessage.setText(message.getMessage());

        try {
            javaMailSender.send(simpleMailMessage);
            System.out.println(simpleMailMessage.getSubject());
            System.out.println(simpleMailMessage.getText());
            for(String a:toArray){
                System.out.println(a);
            }
        }catch (Exception e){
            System.out.println("=========================================");
            System.out.println("에러발생");
            System.out.println("=========================================");
            e.printStackTrace();
            return msg;
        }
        return msg = true;
    }
}

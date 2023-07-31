package com.joeun.service;

import com.joeun.dto.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    @Async
    public boolean sendMailReject(EmailMessage message){
        boolean msg = false;
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("joeunMarketTeam@gamil.com");
        simpleMailMessage.setTo(message.getTo());
        simpleMailMessage.setSubject(message.getSubject());
        simpleMailMessage.setText(message.getMessage());

        try {
            javaMailSender.send(simpleMailMessage);
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

package com.wt.springboot_email.controller;

import com.wt.springboot_email.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class EmailController {


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("sendMail")
    public String sendEmail(EmailDTO emailDTO){

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(emailDTO.getTos());
        mailMessage.setSubject(emailDTO.getSubject());
        mailMessage.setText(emailDTO.getContent());
        javaMailSender.send(mailMessage);

        return "ok";

    }


}

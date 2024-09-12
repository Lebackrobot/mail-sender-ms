package com.example.mail_sender_ms.services;

import com.example.mail_sender_ms.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void send(EmailModel email) {
        System.out.println(email.to());
        System.out.println(email.subject());
    }


}

package com.example.mail_sender_ms.services;

import com.example.mail_sender_ms.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void send(EmailModel email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject(email.subject());
        simpleMailMessage.setFrom(email.from());
        simpleMailMessage.setTo(email.to());
        simpleMailMessage.setText(email.message());

        emailSender.send(simpleMailMessage);
    }
}

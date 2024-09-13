package com.example.mail_sender_ms.services;

import com.example.mail_sender_ms.models.EmailModel;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void send(EmailModel email) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        Context context = new Context();
        context.setVariable("content", email.message());
        String messageProcessed = templateEngine.process("template", context);

        helper.setSubject(email.subject());
        helper.setFrom(email.from());
        helper.setTo(email.to());
        helper.setText(messageProcessed, true);

        emailSender.send(mimeMessage);
    }
}

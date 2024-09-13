package com.example.mail_sender_ms.controllers;

import com.example.mail_sender_ms.dtos.emailDto;
import com.example.mail_sender_ms.models.EmailModel;
import com.example.mail_sender_ms.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @PostMapping
    public ResponseEntity<Object> send(@Valid @RequestBody emailDto payload) {
        try {
            EmailModel emailModel = new EmailModel(
                    this.fromEmail,
                    payload.to(),
                    payload.subject(),
                    payload.message()
            );

            emailService.send(emailModel);

            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "success", true,
                    "info", "...",
                    "message", "Email sent."
            ));
        }

        catch (Exception error) {
            System.out.println(error.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Internal server error"
            ));
        }
    }
}
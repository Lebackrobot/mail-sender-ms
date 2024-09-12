package com.example.mail_sender_ms.controllers;

import com.example.mail_sender_ms.dtos.EmailDTO;
import com.example.mail_sender_ms.models.EmailModel;
import com.example.mail_sender_ms.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;


    @PostMapping
    public ResponseEntity<Object> send(@Valid @RequestBody EmailDTO payload) {
        try {
            // EmailModel email = new EmailModel(payload.message());
            // emailService.send();

            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "success", true,
                    "info", email,
                    "message", "Email sent."
            ));
        }

        catch (Exception error) {
            System.out.println(error);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Internal server error"
            ));
        }
    }
}
package com.example.mail_sender_ms.controllers;

import com.example.mail_sender_ms.dtos.EmailDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/emails")
public class EmailController {
    @PostMapping
    public ResponseEntity<Object> send(@Valid @RequestBody EmailDTO email) {
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "success", true,
                "info", email,
                "message", "Email sent."
        ));
    }
}
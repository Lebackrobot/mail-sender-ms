package com.example.mail_sender_ms.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record emailDto(
        @NotBlank @Email
        String to,

        @NotNull
        String subject,

        @NotNull
        String message
) {}

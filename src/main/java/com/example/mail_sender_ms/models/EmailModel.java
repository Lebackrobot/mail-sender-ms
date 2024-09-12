package com.example.mail_sender_ms.models;

public record EmailModel(
        String from,
        String to,
        String subject,
        String message
) {
}

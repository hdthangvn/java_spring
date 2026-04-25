package com.example.demo.service;

import com.example.demo.entity.mail.EmailEntity;

public interface EmailService {
    String sendTextEmail(EmailEntity email);

    String sendHtmlEmail(EmailEntity email);

    String sendMailAttachmentEmail(EmailEntity email);
}

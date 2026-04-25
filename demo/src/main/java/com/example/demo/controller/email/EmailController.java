package com.example.demo.controller.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.mail.EmailEntity;
import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-text")
    public String sendTextEmail(@RequestBody EmailEntity email) {
        // Implementation for sending a text email
        return emailService.sendTextEmail(email);
    }

    @PostMapping("/send-html")
    public String sendHtmlEmail(@RequestBody EmailEntity email) {
        // Implementation for sending an HTML email
        return emailService.sendHtmlEmail(email);
    }

}

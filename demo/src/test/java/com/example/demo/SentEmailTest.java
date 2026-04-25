package com.example.demo;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.util.EmailSenderUtil;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootTest
public class SentEmailTest {
    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    void sendTextEmail() {
        String to = "user@example.com";
        String subject = "Test OTP Simple";
        String content = "This is a test 1234.";
        emailSenderUtil.sendTextEmail(to, subject, content);
    }

    @Test
    void sendHtmlEmail() throws IOException {
        String to = "user@example.com";
        String subject = "Test OTP HTML";
        String content = "OTP is 123";
        Resource resource = new ClassPathResource("/templates/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendHtmlEmail(to, subject, htmlContent);
    }

}

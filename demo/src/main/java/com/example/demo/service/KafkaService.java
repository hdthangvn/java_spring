package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.entity.mail.EmailEntity;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class KafkaService {

    @Autowired
    private EmailService emailService;

    private final Object objectMapper = new ObjectMapper();

    @KafkaListener(topics = "otp-auth-topic", groupId = "otp-group-id")
    public void listenOTP(String message) {
        try {
            JsonNode jsonNode = ((ObjectMapper) objectMapper).readTree(message);
            String email = jsonNode.get("email").textValue();
            String otp = jsonNode.get("otp").textValue();

            if (email == null || otp == null) {
                throw new IllegalArgumentException("Invalid Kafka message: missing 'email' or 'otp'");
            }

            log.info("otp is {}: email is {}", otp, email);
            EmailEntity emailEntity = new EmailEntity();
            emailEntity.setToEmail(email);
            emailEntity.setSubject("Your OTP FROM KAFKA");
            emailEntity.setMessageBody("Your OTP code is: " + otp);

            String result = emailService.sendTextEmail(emailEntity);
            log.info("result is {}: email is {}, otp is {}", result, email, otp);

        } catch (Exception e) {
            log.error("Error occurred while processing Kafka message", e);
            throw new RuntimeException(e);
        }
    }
}

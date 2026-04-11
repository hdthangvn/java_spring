// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Value;

// @RestController
// public class PlayerController {
// @Value("${player.username}")
// private String PlayerName;
// @Value("${player.age}")
// private int PlayerAge;
// @Value("${player.address}")
// private String PlayerAddress;

// @GetMapping("/player/1")
// public String getPlayerInfo() {
// return "Player Name: " + PlayerName + ", Age: " + PlayerAge + ", Address: " +
// PlayerAddress;
// }
// }
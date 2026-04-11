package com.example.demo.service.impl;

import com.example.demo.entity.user.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        // Implementation for creating a user
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        // Implementation for getting all users
        return userRepository.findAll();
    }
}

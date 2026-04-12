package com.example.demo.service.impl;

import com.example.demo.entity.user.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public UserEntity findByUserNameAndUserEmail(String userName, String userEmail) {
        // Implementation for finding a user by username and email
        return userRepository.findByUserNameAndUserEmail(userName, userEmail);
    }

    @Override
    public Page<UserEntity> findAllUsers(Pageable pageable) {
        // Implementation for finding users with pagination
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> findByUserName(String userName, Pageable pageable) {
        // Implementation for finding users by username with pagination
        return userRepository.findByUserName(userName, pageable);
    }

}
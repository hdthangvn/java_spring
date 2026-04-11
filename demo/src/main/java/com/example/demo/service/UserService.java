package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.user.UserEntity;

public interface UserService {
    UserEntity createUser(UserEntity user);

    List<UserEntity> getAllUsers();
}

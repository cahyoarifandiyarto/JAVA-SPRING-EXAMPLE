package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.UserResponse;

public interface UserService {

    UserResponse register(User user);

    UserResponse login(String email, String password);

}

package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.model.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserService userService;

    public UserResponse register(User user) {
        User data = userService.findByEmail(user.getEmail());

        if (data != null) {
            throw new NullPointerException("Email telah digunakan");
        }

        User newUser = userService.save(user);


        return new UserResponse(
                newUser.getId(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail()
        );

    }

    public UserResponse login(String email, String password) {
        User data = userService.findByEmailAndPassword(email, password);

        if (data == null) {
            throw new NullPointerException("Email atau password salah");
        }

        return new UserResponse(
                data.getId(),
                data.getFirstName(),
                data.getLastName(),
                data.getEmail()
        );

    }
}

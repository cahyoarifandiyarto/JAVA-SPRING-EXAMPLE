package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.model.WebResponse;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public WebResponse<UserResponse> register(@RequestBody CreateUserRequest createUserRequest) {
        User user = new User(
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword()
        );

        UserResponse newUser = userService.register(user);

        return new WebResponse<>(
                200,
                "OK",
                newUser
        );
    }

    @PostMapping("/login")
    public WebResponse<UserResponse> login(@RequestBody CreateUserRequest createUserRequest) {

        UserResponse dataUser = userService.login(createUserRequest.getEmail(), createUserRequest.getPassword());

        return new WebResponse<>(
                200,
                "OK",
                dataUser
        );
    }

}

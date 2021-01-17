package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public interface UserService extends UserRepository {

    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}

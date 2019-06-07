package com.example.lettertome.service;

import com.example.lettertome.model.User;
import com.example.lettertome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

}

package com.example.lettertome.service;

import com.example.lettertome.model.User;
import com.example.lettertome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        List<User> result=(List<User>) userRepository.findAll();
        return result;
    }

    public void create(User user) {
        userRepository.save(user);
    }

}

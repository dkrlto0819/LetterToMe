package com.example.lettertome.controller;

import com.example.lettertome.model.User;
import com.example.lettertome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @GetMapping
    public void get(){

    }
}

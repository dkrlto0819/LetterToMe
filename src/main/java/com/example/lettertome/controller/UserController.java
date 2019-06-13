package com.example.lettertome.controller;

import com.example.lettertome.model.User;
import com.example.lettertome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<User> get(){
        return userService.list();
    }

    @GetMapping("/{number}")
    public User get(@PathVariable Integer number){return userService.get(number);}

    public void update(@RequestBody User user) {userService.update(user); }

    @DeleteMapping("/{number}")
    public void delete(@PathVariable Integer number) {userService.delete(number); }
}

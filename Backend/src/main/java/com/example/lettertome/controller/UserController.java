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
    public void create(User user){
        userService.create(user);
    }

    @GetMapping
    public List<User> get(){
        return userService.list();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable String id){return userService.get(id);}

    public void update(@RequestBody User user) {userService.update(user); }

    @DeleteMapping("/{number}")
    public void delete(@PathVariable Integer number) {userService.delete(number); }
}

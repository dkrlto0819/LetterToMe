package com.example.lettertome.controller;

import com.example.lettertome.model.User;
import com.example.lettertome.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserService userService;

//    @PostMapping
//    public void create(@RequestBody User user){
//        userService.create(user);
//    }

    @PostMapping
    public void signup(@RequestBody User user){
        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info("hello!");
        //logger.info("this is request : " + request.getParameter("id"));

//        User user = new User();
//        user.setId(request.getParameter("id"));
//        user.setPassword(request.getParameter("password"));
//        user.setEmail(request.getParameter("email"));
        try {

            userService.create(user);
        }catch (Exception e) {
            log.info("test" + e);
        }

    }

    @PostMapping("/signin")
    public User signin(@RequestBody User user) {
        String id = user.getId();
        String password=user.getPassword();

        Logger logger = LoggerFactory.getLogger(UserController.class);
        User newUser = new User();
        newUser = userService.get(id);

        if (newUser == null) {
            return null;
        } else if (id.equals(newUser.getId()) && password.equals(newUser.getPassword())) {
            return user;
        }else{
            return null;
        }
    }

    @PostMapping("/resetpassword")
    public User resetpassword(@RequestBody User user) {
        String id = user.getId();
        String email=user.getEmail();

        Logger logger = LoggerFactory.getLogger(UserController.class);
        User newUser = new User();
        newUser = userService.get(id);

        if (newUser == null) {
            return null;
        } else if (id.equals(newUser.getId()) && email.equals(newUser.getEmail())) {
            newUser.setPassword("1234");
            userService.update(newUser);
            return user;
        }else{
            return null;
        }
    }




    @GetMapping
    public List<User> get(){
        return userService.list();
    }


    @GetMapping("/{id}")
    public User get(@PathVariable String id){return userService.get(id);}

    @PutMapping
    public void update(@RequestBody User user) {userService.update(user); }

    @DeleteMapping("/{number}")
    public void delete(@PathVariable Integer number) {userService.delete(number); }
}

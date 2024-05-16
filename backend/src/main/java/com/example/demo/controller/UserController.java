package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserEntity user){
        return userService.registerNewUserAccount(user);
    }

    @GetMapping("/user/{email}")
    public UserEntity getUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email);
    }
}
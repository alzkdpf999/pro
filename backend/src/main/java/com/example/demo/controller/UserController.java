package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPasswd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "Login successful";
    }
}

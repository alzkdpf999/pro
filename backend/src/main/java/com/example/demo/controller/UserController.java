package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/join")
    public String joinPage(){
        return "joinPage";
    }
    @PostMapping("/join")
    public String joinAction(UserDto userDto){
        userService.join(userDto);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginAction(){
        return "loginPage";
    }
    @PostMapping("/login")
    public String loginAction(HttpServletRequest request, UserDto userDto){
        UserEntity user = userService.login(userDto);
        if(user == null){
            return "/redirect:/login";
        }
        return "redirect:?";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
}

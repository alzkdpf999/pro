package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private JpaUserRepository userRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public UserEntity registerUser(UserEntity user) {
//        user.setPasswd(passwordEncoder.encode(user.getPasswd()));
//        user.setCreateDate(new Date());
        return userRepository.save(user);
    }
}

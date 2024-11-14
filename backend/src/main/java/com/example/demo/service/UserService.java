package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.JpaUserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {


    private final JpaUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    public UserService(JpaUserRepository userRepository, BCryptPasswordEncoder bcryptpasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bcryptpasswordEncoder;
    }

    public Long join(UserDto userDto) {

        UserEntity user = UserEntity.builder()
                .email(userDto.getEmail())
                .passwd(bCryptPasswordEncoder.encode(userDto.getPasswd()))
                .name(userDto.getName())
                .build();

        return userRepository.save(user).getUserId();
    }

}

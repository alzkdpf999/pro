package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired

    public UserService(JpaUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void join(UserDto userDto) {

        UserEntity user = UserEntity.builder()
                .email(userDto.getEmail())
                .passwd(passwordEncoder.encode(userDto.getPasswd()))
                .name(userDto.getName())
                .build();

        userRepository.save(user);
    }

    public UserEntity login(UserDto userDto) {
        String userEmail = userDto.getEmail();
        Optional<UserEntity> getUser = userRepository.findByUserEmail(userEmail);
        if (getUser.isPresent()) {
            UserEntity user = getUser.get();
            if (user.getPasswd().equals(userDto.getPasswd())) {
                return user;
            }
        }
        return null;
    }
}

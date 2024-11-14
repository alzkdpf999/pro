 package com.example.demo.service;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.stereotype.Service;

 import com.example.demo.repository.JpaUserRepository;

 @Service
 public class CustomUserDetailsService implements UserDetailsService {

     private final JpaUserRepository userRepository;

     @Autowired
     public CustomUserDetailsService(JpaUserRepository userRepository) {
         this.userRepository = userRepository;
     }

	@Override
	public UserDetails loadUserByUsername(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new IllegalArgumentException((email)));
	}

 }

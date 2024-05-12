package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

}

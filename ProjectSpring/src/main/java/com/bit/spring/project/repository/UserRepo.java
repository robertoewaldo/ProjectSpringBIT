package com.bit.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.spring.project.entity.User;

public interface UserRepo extends JpaRepository<User, String>{

}

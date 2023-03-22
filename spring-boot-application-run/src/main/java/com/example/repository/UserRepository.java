package com.example.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
@Primary
public interface UserRepository extends JpaRepository<User,Integer> {

    // User findByEmail(String email);
    
}
//entity -> repo -> service -> controller
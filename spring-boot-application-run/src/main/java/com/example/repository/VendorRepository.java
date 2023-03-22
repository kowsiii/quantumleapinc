package com.example.repository;

import org.springframework.stereotype.Repository;


@Repository
public interface VendorRepository extends UserRepository {

    // User findByEmail(String email);
    
}
//entity -> repo -> service -> controller
package com.example.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.entity.Vendor;


@Repository
public interface VendorRepository extends UserRepository {

    Vendor findByVendorId(int vendorId);

    // User findByEmail(String email);
    
}
//entity -> repo -> service -> controller
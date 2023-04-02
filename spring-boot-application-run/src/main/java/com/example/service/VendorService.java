package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.entity.User;
import com.example.entity.Vendor;
import com.example.entity.returnMsg;
import com.example.repository.UserRepository;
import com.example.repository.VendorRepository;
 

//talks to repo
@Service
public class VendorService {
    
    @Autowired
    private VendorRepository repository;

    public Vendor saveVendor(Vendor e){
        return repository.save(e);
    }

}
//entity -> repo -> service -> controller
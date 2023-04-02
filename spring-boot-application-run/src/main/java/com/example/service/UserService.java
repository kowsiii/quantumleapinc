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
public class UserService {
    
    @Autowired
    private UserRepository repository;

    // public Vendor saveEmployee(Vendor e){
    //     return repository.save(e);
    // }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(int id){
        return repository.findById(id).get();
    }}

    // public User validateUser(String email, String password){
    //     User e= repository.findByEmail(email);
    //     if(e.getPassword().equals(password)){
    //         return e;
    //     } else{
    //         System.out.println(e.getPassword());
    //         System.out.println(password);
    //         return null;
    //     }
    // }

//entity -> repo -> service -> controller
package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.entity.Employee;
import com.example.entity.User;
import com.example.entity.Vendor;
import com.example.entity.returnMsg;
import com.example.repository.EmployeeRepository;
import com.google.gson.Gson;  

//talks to repo
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee e){
        return repository.save(e);
    }

}
//entity -> repo -> service -> controller
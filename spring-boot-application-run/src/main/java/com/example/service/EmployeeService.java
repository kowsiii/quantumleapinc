package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

//talks to repo
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee e){
        return repository.save(e);
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }
}

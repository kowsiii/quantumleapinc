package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.entity.Employee;
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

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).get();
    }

    public Employee validateUser(String email, String password){
        Employee e= repository.findByEmail(email);
        if(e.getPassword().equals(password)){
            return e;
        } else{
            System.out.println(e.getPassword());
            System.out.println(password);
            return null;
        }
    }

    public String deleteEmployee(int id){
        // try{
        //     repository.deleteById(id);
        // }catch(Exception e){
        //     return "No Such Employee";
        // }
        
        // return "Employee deleted";
        Optional<Employee> e = repository.findById(id);
        System.out.println(e);
        if(ObjectUtils.isEmpty(e)){
            returnMsg m = new returnMsg(400,"error");
            return new Gson().toJson(m);
        }
        returnMsg m = new returnMsg(200,"no error");
        //add delete statement
        return new Gson().toJson(m);
    }
}
//entity -> repo -> service -> controller
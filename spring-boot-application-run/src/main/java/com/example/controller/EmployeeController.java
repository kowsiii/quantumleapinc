package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private UserService service;

    //pathvariable and request body

    //(from UMl - add user)
    @PostMapping("/saveEmployee")
    public User addEmployee(@RequestBody User e){
        return service.saveEmployee(e);
    }
    //(from UMl - get All users)
    @GetMapping("/getAll")
    public List<User> getEmployees(){
        return service.getEmployees();
    }

    //(from UMl - get user by ID)
    @GetMapping("/getById/{id}")
    public User getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    //(from UML validate user)
    @GetMapping("/validate/{email}/{password}")
    public User validateUser(@PathVariable String email,@PathVariable String password){
        return service.validateUser(email, password);
    }

    //(from UML remove user)
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }




    @RequestMapping("/")
    public String getEmployee(){
        return "working";
    }
    

}
//entity -> repo -> service -> controller
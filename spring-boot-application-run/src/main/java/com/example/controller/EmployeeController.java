package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //pathvariable and request body
    @PostMapping("/saveEmployee")
    public Employee addEmployee(@RequestBody Employee e){
        return service.saveEmployee(e);
    }

    @GetMapping("/getAll")
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }
    @GetMapping("/getById")
    public Employee getEmployeeById(){
        return service.getEmployeeById();
    }

    @GetMapping("/exists")
    public int exists(){
        return service.employeeExist();
    }

    @RequestMapping("/")
    public String getEmployee(){
        return "working";
    }
    

}

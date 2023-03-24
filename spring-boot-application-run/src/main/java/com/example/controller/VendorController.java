package com.example.controller;

import java.util.List;

import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.entity.Vendor;
import com.example.service.UserService;
import com.example.service.VendorService;
@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService service;

    //pathvariable and request body

    //(from UMl - add user)
    @PostMapping("/saveVendor")
    public Vendor addEmployee(@RequestBody Vendor e){
        return service.saveVendor(e);
    }
 

}
//entity -> repo -> service -> controller
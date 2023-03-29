package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.entity.User;
import com.example.entity.Vendor;
import com.example.entity.returnMsg;
import com.example.repository.UserRepository;
import com.example.repository.VendorRepository;
import com.google.gson.Gson;  

//talks to repo
@Service
public class VendorService {
    
    @Autowired
    private VendorRepository repository;

    public Vendor saveVendor(Vendor e){
        Vendor w  = repository.findByVendorId(e.getVendorId());
        if(ObjectUtils.isEmpty(w)){
            return repository.save(e);
        }
        return null;
        
    }

    public String editVendor(Vendor e){
        Vendor update  = repository.findByVendorId(e.getVendorId());
        if (update == null){
            returnMsg m = new returnMsg(400,"error");
            return new Gson().toJson(m);
        }
        update.setId(e.getId());
        update.setName(e.getName());
        update.setPassword(e.getPassword());
        update.setVendorId(e.getVendorId());
        update.setVendorRegNo(e.getVendorRegNo());
        repository.save(e);
        return new Gson().toJson(e) ;
    }

}

//entity -> repo -> service -> controller
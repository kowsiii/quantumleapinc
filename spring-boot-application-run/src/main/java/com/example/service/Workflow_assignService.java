package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.User;
import com.example.entity.Vendor;
import com.example.entity.Workflow;
import com.example.entity.Workflow_assign;
import com.example.entity.returnMsg;
import com.example.repository.UserRepository;
import com.example.repository.WorkflowRepository;
import com.example.repository.Workflow_assignRepository;
import com.google.gson.Gson;  

//talks to repo
@Service
public class Workflow_assignService {
    
    @Autowired
    private Workflow_assignRepository repository;

    //get all workflows
    public List<Workflow_assign> getAllAssignedWorkflows(){
        return repository.findAll();
    }

    //assign workflow
    public Workflow_assign assignWorkflow(Workflow_assign w){
        return repository.save(w);
    }

}
//entity -> repo -> service -> controller
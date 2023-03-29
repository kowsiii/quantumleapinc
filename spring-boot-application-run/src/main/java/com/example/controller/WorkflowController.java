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
import com.example.entity.Workflow;
import com.example.service.UserService;
import com.example.service.WorkflowService;
@RestController
@RequestMapping("/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService service;

    @GetMapping("/getAll")
    public List<Workflow> getWorkflows(){
        return service.getWorkflows();
    }

    @PostMapping("/saveWorkflow")
    public Workflow saveWorkflow(@RequestBody Workflow w){
        return service.saveWorkflow(w);
    }


}
//entity -> repo -> service -> controller
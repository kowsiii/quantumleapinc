package com.example.controller;

import java.util.List;

import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.entity.Vendor;
import com.example.entity.Workflow;
import com.example.entity.Workflow_assign;
import com.example.service.UserService;
import com.example.service.WorkflowService;
import com.example.service.Workflow_assignService;
@RestController
@RequestMapping("/workflowAssign")
public class Workflow_assignController {

    @Autowired
    private Workflow_assignService service;

    @GetMapping("/getAll")
    public List<Workflow_assign> getAllAssignedWorkflows(){
        return service.getAllAssignedWorkflows();
    }

    @PostMapping("/assignWorkflow")
    public Workflow_assign assignWorkflow(@RequestBody Workflow_assign w){
        return service.assignWorkflow(w);
    }

    @PutMapping("/updateStatus/{workFlowAssign_id}")
    public String updateWorkflowStatus(@PathVariable int workFlowAssign_id){
        return service.updateWorkflowStatus(workFlowAssign_id);
    }


}
//entity -> repo -> service -> controller
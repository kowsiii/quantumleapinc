package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow,Integer> {

    // User findByEmail(String email);
    
}
//entity -> repo -> service -> controller
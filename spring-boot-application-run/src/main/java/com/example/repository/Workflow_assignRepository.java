package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Workflow;
import com.example.entity.Workflow_assign;

@Repository
public interface Workflow_assignRepository extends JpaRepository<Workflow_assign,Integer> {
    
    // User findByEmail(String email);
    
}
//entity -> repo -> service -> controller
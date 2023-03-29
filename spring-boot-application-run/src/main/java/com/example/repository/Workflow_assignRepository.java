package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Workflow;
import com.example.entity.Workflow_assign;

@Repository
public interface Workflow_assignRepository extends JpaRepository<Workflow_assign,Integer> {

    List<Workflow_assign> findByVendorId(int vendorId);

    List<Workflow_assign> getAllByVendorId(int vendorId);

    List<Workflow_assign> findAllByVendorId(int vendorId);
    
    // User findByEmail(String email);
    
}
//entity -> repo -> service -> controller
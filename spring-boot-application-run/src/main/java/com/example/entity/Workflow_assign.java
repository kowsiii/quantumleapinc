package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Workflow_assign")
public class Workflow_assign {
    @Id
    @GeneratedValue
    private int workFlow_assign_id;
    private int workFlow_id;
    // @Column(name ="v_RegNo")
    private int vendorId;
    private int assignedBy;//employeeId
    private String workFlowName;
    private String workFlowJsonString;
}

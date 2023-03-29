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
@Table(name = "Workflow")
public class Workflow {
    @Id
    @GeneratedValue
    private int workFlowId;
    // @Column(name ="v_RegNo")
    private int createdBy;//employeeId
    private String workFlowName;
    private String workFlowJsonString;
}

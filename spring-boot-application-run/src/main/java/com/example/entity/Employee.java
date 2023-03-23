package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Employee")
public class Employee extends User {
    // @Column(name ="v_UserId")
    private int employeeUserId;
    // @Column(name ="v_RegNo")
    private String employeeId;//is it needed?
    private String employeeName;
    private String employeeType;
    private int employeeContactNo;
}

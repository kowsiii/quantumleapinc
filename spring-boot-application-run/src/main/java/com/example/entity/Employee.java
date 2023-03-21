package com.example.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name ="employee_Id")
    private int id;
    @Column(name ="employee_Name")
    private String name;
    @Column(name ="employee_Email")
    private String email;
    @Column(name ="employee_Password")
    private String password;
    @Column(name ="employee_Type")
    private String type;
}

//entity -> repo -> service -> controller
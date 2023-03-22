package com.example.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@MappedSuperclass
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name ="userId")
    private int id;
    @Column(name ="loginUserName")
    private String name;
    @Column(name ="userPassword")
    private String password;
    @Column(name ="userType")
    private String userType;

}

//entity -> repo -> service -> controller
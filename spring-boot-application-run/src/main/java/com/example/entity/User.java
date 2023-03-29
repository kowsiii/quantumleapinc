package com.example.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;

// import jakarta.persistence.MappedSuperclass;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;

// import lombok.AccessLevel;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class User implements Serializable {
    @Id
    @GeneratedValue
    // @Column(name ="userId")
    private int id;
    // @Column(name ="loginUserName")
    private String name;
    // @Column(name ="userPassword")
    private String password;
    // @Column(name ="userType")
    // private String userType;

}

//entity -> repo -> service -> controller
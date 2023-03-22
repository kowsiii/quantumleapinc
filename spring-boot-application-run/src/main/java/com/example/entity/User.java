package com.example.entity;


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
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class User {
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

    public User(){}
    public User(String name, String userPassword){
        this.name = name;
        this.password= userPassword;
    }
    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }

}

//entity -> repo -> service -> controller
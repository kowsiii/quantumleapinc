package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Vendor")
public class Vendor extends User {
    // @Column(name ="v_UserId")
    private int vendorId;
    // @Column(name ="v_RegNo")
    private int vendorRegNo;
    // @Column(name ="poc")
    // private String vendorPoc;
    // @Column(name ="vendorEmail")
    // private String vendorEmail;
    // @Column(name ="officeAddress")
    // private String vendorOffice;
    // @Column(name ="officeTelephone")
    // private int vendorTelephone;
    // @Column(name ="lineOfBusiness")
    // // private String vendorLob;

}

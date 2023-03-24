package com.example.entity;

import org.hibernate.annotations.SQLInsert;

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
@Table(name = "Permissions")
@SQLInsert(sql = "INSERT INTO Permissions(permission_write, permission_read, modified_by) " +
        "VALUES (true, true, lols)" )
public class FormPermissions{

    @Id
    @GeneratedValue
    private int permissionId;
    @Column(name = "permission_write", nullable = false)
    private boolean permissionWrite;
    @Column(name = "permission_read", nullable = false)
    private boolean permissionRead;
    @Column(name = "modified_by", nullable = false)
    private String modifiedBy;

    public FormPermissions(boolean b, boolean c, String string) {
        this.permissionWrite = b;
        this.permissionRead = c;
        this.modifiedBy = string;
    } 
}

package oop.quantumleapinc.vms.login.payload.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 255)
    @Email
    private String username;

    @NotBlank
    @Size(max = 255)
    @Column(nullable=false, unique=false)
    private String name;

    // private Set<String> role;
    private String role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public Set<String> getRole() {
    //     return this.role;
    // }

    // public void setRole(Set<String> role) {
    //     this.role = role;
    // }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
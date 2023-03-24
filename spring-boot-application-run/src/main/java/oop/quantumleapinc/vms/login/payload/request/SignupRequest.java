package oop.quantumleapinc.vms.login.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class SignupRequest {
    @NotBlank
    @Email
    @Size(min = 3, max = 50)
    private String username;

    // @NotBlank
    // @Size(max = 50)
    // @Email
    // private String email;

    //private Set<String> role;
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

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

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
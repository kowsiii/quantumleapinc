package oop.quantumleapinc.vms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
@JsonIgnoreProperties({"password"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Email
    @Column(nullable=false, unique=true)
    private String username;

    @NotBlank
    @Size(max = 255)
    @Column(nullable=false, unique=false)
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(nullable=false, unique=false)
    private String password;

    @NotBlank
    @Size(min = 1, max = 1)
    @Column(length=1, nullable=false, unique=false)
    private String active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Boolean getActiveStatus() {
        return active.equalsIgnoreCase("Y") ? Boolean.TRUE : Boolean.FALSE;
    }


}

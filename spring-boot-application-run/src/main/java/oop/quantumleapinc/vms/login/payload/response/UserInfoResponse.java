package oop.quantumleapinc.vms.login.payload.response;

import java.util.List;

public class UserInfoResponse {
    private Long id;
    private String username;
    private List<String> roles;
    private String accessToken;
    private String name;

    public UserInfoResponse(Long id, String username, List<String> roles, String accessToken, String name) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.accessToken = accessToken;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getAccessToken() { return accessToken; }

    public String getName() {
        return name;
    }
}
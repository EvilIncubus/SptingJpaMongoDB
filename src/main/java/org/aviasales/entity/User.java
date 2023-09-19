package org.aviasales.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private int userId;
    private String email;
    private String password;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = ("yyyy-MM-dd hh:mm:ss"))
    private LocalDateTime createdDate;
    private List<Roles> roles;

    public User(int userId, String email, String password, LocalDateTime createdDate, List<Roles> roles) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.roles = roles;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}

package org.example.entity;

import org.example.enums.UserRole;

public class User {
    private String id;
    private UserRole role;

    public User(String id, UserRole role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

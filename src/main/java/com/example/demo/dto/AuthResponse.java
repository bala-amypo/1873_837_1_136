package com.example.demo.dto;

public class AuthResponse {
    private Long userId;
    private String email;
    private String fullName;
    private String role;

    // Getters
    public Long getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
    public String getRole() { return role; }

    // Setters
    public void setUserId(Long userId) { this.userId = userId; }
    public void setEmail(String email) { this.email = email; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setRole(String role) { this.role = role; }
}

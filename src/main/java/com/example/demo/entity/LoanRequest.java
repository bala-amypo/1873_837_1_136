package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class LoanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Double requestedAmount;
    private Integer tenureMonths;
    private String status;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Double getRequestedAmount() { return requestedAmount; }
    public void setRequestedAmount(Double requestedAmount) { this.requestedAmount = requestedAmount; }

    public Integer getTenureMonths() { return tenureMonths; }
    public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

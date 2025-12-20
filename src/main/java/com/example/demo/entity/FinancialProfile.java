package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "financial_profiles")
public class FinancialProfile {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "profile_id")
private Long id;


@OneToOne
@JoinColumn(name = "user_id", nullable = false, unique = true)
private User user;


@Column(nullable = false)
private Double monthlyIncome;


@Column(nullable = false)
private Double monthlyExpenses;


@Column(nullable = false)
private Double existingLoanEmi;


@Column(nullable = false)
private Integer creditScore;


@Column(nullable = false)
private Double savingsBalance;


@Column(nullable = false)
private LocalDateTime lastUpdatedAt = LocalDateTime.now();


// getters and setters
}
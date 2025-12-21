package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "eligibility_results")
public class EligibilityResult {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "eligibility_id")
private Long id;


@OneToOne
@JoinColumn(name = "loan_request_id", nullable = false, unique = true)
private LoanRequest loanRequest;


@Column(nullable = false)
private Boolean isEligible;


private Double maxEligibleAmount;


private Double estimatedEmi;


@Column(nullable = false)
private String riskLevel;


private String rejectionReason;


@Column(nullable = false)
private LocalDateTime calculatedAt = LocalDateTime.now();


// getters and setters
}
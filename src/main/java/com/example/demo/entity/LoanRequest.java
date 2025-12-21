package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "loan_requests")
public class LoanRequest {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "loan_request_id")
private Long id;


@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private User user;


@Column(nullable = false)
private Double requestedAmount;


@Column(nullable = false)
private Integer tenureMonths;


private String purpose;


@Column(nullable = false)
private String status = "PENDING";


@Column(nullable = false)
private LocalDateTime appliedAt = LocalDateTime.now();


// getters and setters
}
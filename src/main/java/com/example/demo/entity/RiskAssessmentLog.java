package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "risk_assessment_logs")
public class RiskAssessmentLog {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "risk_log_id")
private Long id;


@Column(nullable = false)
private Long loanRequestId;


@Column(nullable = false)
private Double dtiRatio;


@Column(nullable = false)
private String creditCheckStatus;


@Column(nullable = false)
private LocalDateTime timestamp = LocalDateTime.now();


// getters and setters
}
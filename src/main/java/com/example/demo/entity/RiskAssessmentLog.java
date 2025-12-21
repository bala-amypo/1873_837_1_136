package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RiskAssessmentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;
    private double dtiRatio;
    private String creditCheckStatus;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getLoanRequestId() { return loanRequestId; }
    public void setLoanRequestId(Long loanRequestId) { this.loanRequestId = loanRequestId; }

    public double getDtiRatio() { return dtiRatio; }
    public void setDtiRatio(double dtiRatio) { this.dtiRatio = dtiRatio; }

    public String getCreditCheckStatus() { return creditCheckStatus; }
    public void setCreditCheckStatus(String creditCheckStatus) { this.creditCheckStatus = creditCheckStatus; }
}

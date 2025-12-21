package com.example.demo.dto;

public class LoanDtos {

    public static class LoanRequestDto {
        private Long id;
        private Long userId;
        private Double requestedAmount;
        private Integer tenureMonths;
        private String purpose;
        private String status;

        public LoanRequestDto() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }

        public Double getRequestedAmount() { return requestedAmount; }
        public void setRequestedAmount(Double requestedAmount) { this.requestedAmount = requestedAmount; }

        public Integer getTenureMonths() { return tenureMonths; }
        public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }

        public String getPurpose() { return purpose; }
        public void setPurpose(String purpose) { this.purpose = purpose; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }

    public static class FinancialProfileDto {
        private Long id;
        private Long userId;
        private Double monthlyIncome;
        private Double monthlyExpenses;
        private Double existingLoanEmi;
        private Integer creditScore;
        private Double savingsBalance;

        public FinancialProfileDto() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }

        public Double getMonthlyIncome() { return monthlyIncome; }
        public void setMonthlyIncome(Double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

        public Double getMonthlyExpenses() { return monthlyExpenses; }
        public void setMonthlyExpenses(Double monthlyExpenses) { this.monthlyExpenses = monthlyExpenses; }

        public Double getExistingLoanEmi() { return existingLoanEmi; }
        public void setExistingLoanEmi(Double existingLoanEmi) { this.existingLoanEmi = existingLoanEmi; }

        public Integer getCreditScore() { return creditScore; }
        public void setCreditScore(Integer creditScore) { this.creditScore = creditScore; }

        public Double getSavingsBalance() { return savingsBalance; }
        public void setSavingsBalance(Double savingsBalance) { this.savingsBalance = savingsBalance; }
    }
}

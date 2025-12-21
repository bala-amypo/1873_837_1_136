package com.example.demo.controller;

import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.repository.RiskAssessmentLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-logs")
public class RiskLogController {

    private final RiskAssessmentLogRepository logRepository;

    public RiskLogController(RiskAssessmentLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @GetMapping("/{loanRequestId}")
    public List<RiskAssessmentLog> getLogs(@PathVariable Long loanRequestId) {
        return logRepository.findByLoanRequestId(loanRequestId);
    }
}

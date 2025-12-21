package com.example.demo.controller;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    private final LoanEligibilityService eligibilityService;

    public EligibilityController(LoanEligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @PostMapping("/evaluate/{loanRequestId}")
    public ResponseEntity<EligibilityResult> evaluate(
            @PathVariable Long loanRequestId) {

        EligibilityResult result =
                eligibilityService.evaluateEligibility(loanRequestId);

        return ResponseEntity.ok(result);
    }
}

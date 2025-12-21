package com.example.demo.controller;

import com.example.demo.entity.LoanRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan-request")
public class LoanRequestController {

    @PostMapping
    public ResponseEntity<LoanRequest> createLoanRequest(@RequestBody LoanRequest loanRequest) {
        // Save logic here
        return ResponseEntity.ok(loanRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRequest> getLoanRequest(@PathVariable Long id) {
        LoanRequest request = new LoanRequest(); // fetch logic here
        return ResponseEntity.ok(request);
    }
}

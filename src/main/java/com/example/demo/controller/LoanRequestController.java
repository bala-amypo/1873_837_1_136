package com.example.demo.controller;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    private final LoanRequestRepository loanRequestRepository;
    private final UserRepository userRepository;

    public LoanRequestController(LoanRequestRepository loanRequestRepository,
                                 UserRepository userRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> applyLoan(
            @PathVariable Long userId,
            @RequestBody LoanRequest loanRequest) {

        return userRepository.findById(userId)
                .map(user -> {
                    loanRequest.setUser(user);
                    loanRequest.setStatus("PENDING");
                    return ResponseEntity.ok(loanRequestRepository.save(loanRequest));
                })
                .orElse(ResponseEntity.badRequest().body("User not found"));
    }

    @GetMapping("/user/{userId}")
    public List<LoanRequest> getLoansByUser(@PathVariable Long userId) {
        return loanRequestRepository.findByUserId(userId);
    }
}

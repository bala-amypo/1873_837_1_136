package com.example.demo.controller;

import com.example.demo.entity.FinancialProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-profile")
public class FinancialProfileController {

    @PostMapping
    public ResponseEntity<FinancialProfile> createProfile(@RequestBody FinancialProfile profile) {
        // Save logic here
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialProfile> getProfile(@PathVariable Long id) {
        FinancialProfile profile = new FinancialProfile(); // fetch logic here
        return ResponseEntity.ok(profile);
    }
}

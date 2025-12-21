package com.example.demo.controller;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-profile")
public class FinancialProfileController {

    private final FinancialProfileRepository profileRepository;
    private final UserRepository userRepository;

    public FinancialProfileController(FinancialProfileRepository profileRepository,
                                      UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> createOrUpdate(
            @PathVariable Long userId,
            @RequestBody FinancialProfile profile) {

        return userRepository.findById(userId)
                .map(user -> {
                    profile.setUser(user);
                    return ResponseEntity.ok(profileRepository.save(profile));
                })
                .orElse(ResponseEntity.badRequest().body("User not found"));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable Long userId) {
        return profileRepository.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body("Profile not found"));
    }
}

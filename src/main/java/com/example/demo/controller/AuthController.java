package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody User user) {
        // 1. Save the user (pseudo-code)
        User savedUser = saveUserToDatabase(user);

        // 2. Prepare AuthResponse using setters
        AuthResponse response = new AuthResponse();
        response.setUserId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFullName(savedUser.getFullName());
        response.setRole(savedUser.getRole());

        // 3. Return response
        return ResponseEntity.ok(response);
    }

    private User saveUserToDatabase(User user) {
        // Your actual save logic goes here
        return user; // temporary placeholder
    }
}

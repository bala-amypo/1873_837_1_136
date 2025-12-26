package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "my-secret-key-1234567890";
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // ================= TOKEN CREATION =================

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // ✅ OVERLOAD (fixes AuthController)
    public String generateToken(String username) {
        return generateToken(new HashMap<>(), username);
    }

    // ================= TOKEN VALIDATION =================

    public boolean validateToken(String token, String username) {
        return getUsernameFromToken(token).equals(username) && !isTokenExpired(token);
    }

    // ✅ OVERLOAD (fixes JwtFilter)
    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    // ================= TOKEN DATA =================

    public String getUsernameFromToken(String token) {
        return getAllClaims(token).getSubject();
    }

    public Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return getAllClaims(token).getExpiration().before(new Date());
    }
}

package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
private Long id;


@Column(nullable = false)
private String fullName;


@Column(nullable = false, unique = true)
private String email;


@Column(nullable = false)
private String password;


@Column(nullable = false)
private String role = "CUSTOMER";


@Column(nullable = false)
private LocalDateTime createdAt = LocalDateTime.now();


// getters and setters
}
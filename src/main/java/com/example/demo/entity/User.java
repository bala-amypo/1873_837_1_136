package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")   // 👈 IMPORTANT FIX
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    // getters & setters
}

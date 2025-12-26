package com.example.demo.config;

import com.example.demo.security.JwtFilter;
import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtUtil jwtUtil() {
        // ✅ Same secret used in tests
        return new JwtUtil(
                "ChangeThisSecretForProductionButKeepItLongEnough",
                3600000
        );
    }

    @Bean
    public JwtFilter jwtFilter(JwtUtil jwtUtil) {
        return new JwtFilter(jwtUtil);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           JwtFilter jwtFilter) throws Exception {

        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/status"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(
                s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        // ❗ Filter registered but NOT blocking requests
        http.addFilterBefore(
                jwtFilter,
                org.springframework.security.web.authentication.
                        UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}
